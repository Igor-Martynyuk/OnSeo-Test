package dev.martyniuk.test.onseo;

import android.app.Application;
import android.widget.Toast;

import dev.martyniuk.test.onseo.core.observer.Observer;
import dev.martyniuk.test.onseo.layer.entities.sport.holder.SportDataHolder;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.Event;
import dev.martyniuk.test.onseo.layer.gateway.assets.main.GatewayAssets;
import dev.martyniuk.test.onseo.layer.gateway.assets.main.GatewayAssetsDefault;
import dev.martyniuk.test.onseo.layer.interactor.UseCaseObserveEvents;
import dev.martyniuk.test.onseo.layer.interactor.UseCaseUpdateEvents;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GatewayAssets gatewayAssets = new GatewayAssetsDefault(getAssets());
        SportDataHolder holder = new SportDataHolder();

        UseCaseUpdateEvents useCase = new UseCaseUpdateEvents(gatewayAssets, holder);
        useCase.subscribe(
                new UseCaseUpdateEvents.CallBack() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        useCase.invoke();

        UseCaseObserveEvents case2 = new UseCaseObserveEvents(holder);
        case2.invoke(
                new Observer<Event>() {
                    @Override
                    public void notify(Event value) {
                        Toast.makeText(getApplicationContext(), value.getId(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
