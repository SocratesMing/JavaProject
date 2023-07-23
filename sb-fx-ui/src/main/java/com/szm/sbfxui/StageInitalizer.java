package com.szm.sbfxui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitalizer implements ApplicationListener<FxApplication.StageReadyEvent> {

    @Value("classpath:/demo.fxml")
    private Resource resource;
    @Override
    public void onApplicationEvent(FxApplication.StageReadyEvent event) {
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(resource.getURL());
            Parent parent = loader.load();
            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 800, 600));
            stage.setTitle("SpringBoot-JavaFx");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
