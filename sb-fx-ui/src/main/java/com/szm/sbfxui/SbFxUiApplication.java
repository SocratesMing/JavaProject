package com.szm.sbfxui;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbFxUiApplication {

    public static void main(String[] args) {


        Application.launch(FxApplication.class,args);
//        SpringApplication.run(SbFxUiApplication.class, args);
    }

}
