package org.letcs.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;


public class CalculatorApp extends Application {
    private final String JAVAFX_CONFIG = "calculator.fxml";
    private final String JAVAFX_CSS = "application.css";
    private final String IMAGE_NAME = "image.png";
    private final String GUI_TITLE = "Calculator";
    private final int SCENE_WIDTH = 360;
    private final int SCENE_HEIGHT = 600;

    private final ClassLoader classLoader = CalculatorApp.class.getClassLoader();
    private final CalculatorContext context = CalculatorContext.getInstance();

    @Override
    public void start(Stage primaryStage) {
        try {
            // load GUI configuration and show the calculator interface
            FXMLLoader loader = new FXMLLoader(classLoader.getResource(JAVAFX_CONFIG));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
            scene.getStylesheets().add(Objects.requireNonNull(classLoader.getResource(JAVAFX_CSS)).toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle(GUI_TITLE);
            primaryStage.getIcons().add(new Image(Objects.requireNonNull(classLoader.getResourceAsStream(IMAGE_NAME))));
            primaryStage.show();

            // setup the context
            context.setController(loader.getController());
            context.setScene(scene);
            System.out.println("LETCS calculator launch!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}