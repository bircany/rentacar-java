package com.rentacar;

import com.rentacar.ui.MainUI;
import com.rentacar.util.LogUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RentACarApplication {

    public static void main(String[] args) {
        try {
            LogUtils.info("RentACar Application is starting...");

            // Disable headless mode
            System.setProperty("java.awt.headless", "false");
            
            // Start Spring application with web server
            ConfigurableApplicationContext context = SpringApplication.run(RentACarApplication.class, args);

            // Start Main UI
            MainUI mainUI = context.getBean(MainUI.class);
            mainUI.display();

            LogUtils.info("RentACar Application started successfully.");
        } catch (Exception e) {
            LogUtils.error("Error occurred while starting the application", e);
        }
    }
}