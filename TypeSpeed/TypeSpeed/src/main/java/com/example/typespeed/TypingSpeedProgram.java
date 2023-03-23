package com.example.typespeed;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TypingSpeedProgram extends Application {

    private TextArea textArea;
    private Label speedLabel;

    @Override
    public void start(Stage stage) throws Exception {
        textArea = new TextArea();
        speedLabel = new Label("Type something in the text area to start measuring your typing speed.");

        textArea.setOnKeyTyped(event -> {
            updateSpeedLabel();
        });

        VBox root = new VBox(textArea, speedLabel);
        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("Type Speed Program");
        stage.setScene(scene);
        stage.show();
    }

    private void updateSpeedLabel() {
        String text = textArea.getText();
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        long elapsedTimeMillis = System.currentTimeMillis() - startTimeMillis;
        double elapsedTimeMinutes = elapsedTimeMillis / (1000.0 * 60.0);
        double typingSpeed = wordCount / elapsedTimeMinutes;
        speedLabel.setText(String.format("Your typing speed is %.2f words per minute.", typingSpeed));
    }

    private long startTimeMillis;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        startTimeMillis = System.currentTimeMillis();
    }

}
