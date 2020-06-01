package dev.martyniuk.test.onseo.layer.interactor;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import dev.martyniuk.test.onseo.layer.entities.sport.holder.SportDataHolder;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.Event;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.EventFormula1;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.EventSoccer;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.EventTennis;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.EventValleyBall;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.main.GatewayAssets;

public class UseCaseUpdateEvents {
    private GatewayAssets assets;
    private SportDataHolder model;
    private List<CallBack> callBacks;
    protected Handler handler;
    protected boolean isInProgress;

    public UseCaseUpdateEvents(GatewayAssets assets, SportDataHolder model) {
        this.assets = assets;
        this.model = model;
        this.callBacks = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void subscribe(CallBack callBack) {
        this.callBacks.add(callBack);
    }

    public void unsubscribe(CallBack callBack) {
        this.callBacks.remove(callBack);
    }

    private void notifyStarted() {
        this.handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        for (CallBack callBack : callBacks) {
                            callBack.onStart();
                        }
                    }
                }
        );
    }

    private void notifySuccess() {
        this.handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        for (CallBack callBack : callBacks) {
                            callBack.onSuccess();
                        }
                    }
                }
        );
    }

    private void notifyError(final Throwable e) {
        e.printStackTrace();

        this.handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        for (CallBack callBack : callBacks) {
                            callBack.onError(e);
                        }
                    }
                }
        );
    }

    public void invoke() {
        if (this.isInProgress) return;

        this.isInProgress = true;
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();

                        notifyStarted();

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        try {
                            for (final DtoEventAsset dto : assets.loadEvents()) {

                                final Event event;
                                switch (dto.getSportId()) {
                                    case DtoEventAsset.ID_FORMULA_1:
                                        event = new EventFormula1(dto);
                                        break;
                                    case DtoEventAsset.ID_SOCCER:
                                        event = new EventSoccer(dto);
                                        break;
                                    case DtoEventAsset.ID_TENNIS:
                                        event = new EventTennis(dto);
                                        break;
                                    case DtoEventAsset.ID_VOLLEYBALL:
                                        event = new EventValleyBall(dto);
                                        break;
                                    default:
                                        throw new RuntimeException("Unresolved event");
                                }

                                handler.post(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                model.addEvent(event);
                                            }
                                        }
                                );

                            }

                            notifySuccess();
                        } catch (Exception e) {
                            notifyError(e);
                        }
                    }
                }
        ).start();
    }

    public interface CallBack {
        void onStart();

        void onSuccess();

        void onError(Throwable t);
    }
}
