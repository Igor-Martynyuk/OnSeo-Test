package dev.martyniuk.test.onseo.layer.gateway.assets.main;

import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dev.martyniuk.test.onseo.core.observer.Observable;
import dev.martyniuk.test.onseo.core.observer.Observer;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoParticipantAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoPeriodAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoScoreboardAsset;

@SuppressWarnings("FieldCanBeLocal")
public class GatewayAssetsDefault implements GatewayAssets {
    private final String KEY_ID = "id";
    private final String KEY_SPORT_ID = "sportId";
    private final String KEY_EVENT_ID = "eventId";
    private final String KEY_NAME = "name";
    private final String KEY_NAME_SHORT = "shortName";
    private final String KEY_START_TIME = "startTime";
    private final String KEY_TYPE = "type";
    private final String KEY_IN_PLAY = "inplay";
    private final String KEY_PARTICIPANTS = "participants";
    private final String KEY_SCOREBOARD = "scoreboard";
    private final String KEY_PERIOD = "period";
    private final String KEY_SCORES = "scores";

    private AssetManager assets;
    private Observable<DtoEventAsset> eventsObservable;

    public GatewayAssetsDefault(AssetManager assets) {
        this.assets = assets;
        this.eventsObservable = new Observable<>();
    }

    private List<DtoParticipantAsset> parseParticipants(JSONObject eventJson) throws JSONException {
        JSONArray participantsJson = eventJson.getJSONArray(KEY_PARTICIPANTS);

        List<DtoParticipantAsset> result = new ArrayList<>();
        for (int j = 0; j < participantsJson.length(); j++) {
            JSONObject participantJson = participantsJson.getJSONObject(j);

            result.add(
                    new DtoParticipantAsset(
                            participantJson.getString(KEY_ID),
                            participantJson.getString(KEY_NAME)
                    )
            );
        }

        return result;
    }

    private DtoScoreboardAsset parseScoreboard(JSONObject eventJson) throws JSONException {
        JSONObject scoreboardJson = eventJson.getJSONObject(KEY_SCOREBOARD);
        JSONObject periodJson = scoreboardJson.getJSONObject(KEY_PERIOD);
        JSONObject scoresJson = scoreboardJson.getJSONObject(KEY_SCORES);

        DtoPeriodAsset period = new DtoPeriodAsset(
                periodJson.getString(KEY_ID),
                periodJson.getString(KEY_NAME),
                periodJson.getString(KEY_NAME_SHORT)
        );

        Map<String, Map<String, List<String>>> scoresExternalMap = new HashMap<>();
        Iterator<String> scoresExternalIterator = scoresJson.keys();
        while (scoresExternalIterator.hasNext()) {
            String keyExternal = scoresExternalIterator.next();
            JSONObject scoresExternal = scoresJson.getJSONObject(keyExternal);

            Map<String, List<String>> scoresInternalMap = new HashMap<>();
            Iterator<String> scoresInternalIterator = scoresExternal.keys();
            while (scoresInternalIterator.hasNext()) {
                String keyInternal = scoresInternalIterator.next();
                JSONArray scorePointsJsonArray = scoresExternal.getJSONArray(keyInternal);

                List<String> points = new ArrayList<>();
                for (int j = 0; j < scorePointsJsonArray.length(); j++) {
                    points.add(scorePointsJsonArray.getString(j));
                }

                scoresInternalMap.put(keyInternal, points);
            }

            scoresExternalMap.put(keyExternal, scoresInternalMap);
        }

        return new DtoScoreboardAsset(
                scoreboardJson.getString(KEY_EVENT_ID),
                scoreboardJson.getString(KEY_SPORT_ID),
                period,
                scoresExternalMap
        );
    }

    private List<DtoEventAsset> parseEvents(String sourceStr) throws JSONException {
        List<DtoEventAsset> result = new ArrayList<>();

        JSONArray eventsJsonArray = new JSONObject(sourceStr).getJSONArray("events");
        for (int i = 0; i < eventsJsonArray.length(); i++) {
            JSONObject eventJSON = eventsJsonArray.getJSONObject(i);
            result.add(
                    new DtoEventAsset(
                            eventJSON.getString(KEY_ID),
                            eventJSON.getString(KEY_SPORT_ID),
                            eventJSON.getString(KEY_NAME),
                            eventJSON.getString(KEY_START_TIME),
                            eventJSON.getString(KEY_TYPE),
                            eventJSON.getBoolean(KEY_IN_PLAY),
                            parseParticipants(eventJSON),
                            parseScoreboard(eventJSON)
                    )
            );
        }

        return result;
    }

    @Override
    public void updateEvents() throws Exception {
        try (InputStream input = assets.open("events_stub.json")) {
            byte[] buffer = new byte[input.available()];

            if (input.read(buffer) == buffer.length) {
                for (DtoEventAsset event : parseEvents(new String(buffer, StandardCharsets.UTF_8))) {
                    this.eventsObservable.notify(event);
                }

                return;
            }

            throw new IOException("Source read failed");
        }
    }

    @Override
    public void subscribeEvents(Observer<DtoEventAsset> observer) {
        this.eventsObservable.subscribe(observer);
    }

    @Override
    public void unSubscribeEvents(Observer<DtoEventAsset> observer) {
        this.eventsObservable.unsubscribe(observer);
    }


}
