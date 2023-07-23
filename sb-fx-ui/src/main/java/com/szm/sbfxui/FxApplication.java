package com.szm.sbfxui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class FxApplication extends Application {

    private ConfigurableApplicationContext context;
    public FxApplication() {
        super();
    }

    @Override
    public void init() throws Exception {
        context = new SpringApplicationBuilder(SbFxUiApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        context.publishEvent(new StageReadyEvent(stage));

    }

    @Override
    public void stop() throws Exception {
        context.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {

        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}
