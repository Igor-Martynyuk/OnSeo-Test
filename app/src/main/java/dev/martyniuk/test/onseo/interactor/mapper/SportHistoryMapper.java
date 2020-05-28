package dev.martyniuk.test.onseo.interactor.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import dev.martyniuk.test.onseo.gateway.assets.dto.EventAssetDto;

public class SportHistoryMapper {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());

    public void eventFromAsset(EventAssetDto dto) throws ParseException {

    }

    public void periodFromAsset(){

    }
}
