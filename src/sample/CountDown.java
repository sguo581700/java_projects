package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import static sample.Ball.STAGE_HEIGHT;
import static sample.Ball.STAGE_WIDTH;

public class CountDown {
    private TilePane tilePane;
    private Scene scene;
    private static final Integer START_TIME=11;
    private Integer timeSeconds = START_TIME;
    private javafx.scene.control.Label timerLabel;
    public CountDown() {
        tilePane = new TilePane();
        scene = new Scene(tilePane, STAGE_WIDTH, STAGE_HEIGHT);
        timerLabel = new javafx.scene.control.Label();
    }
    public void setCountDown(Stage stage, Scene scene){
        tilePane.setOrientation(Orientation.VERTICAL);
        tilePane.setAlignment(Pos.CENTER);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(timeline.INDEFINITE);
        //set the frame duration to 1 sec
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                javafx.scene.text.Font font = Font.font("Chalkduster", FontWeight.BOLD,200);
                timeSeconds--;
                timerLabel.setFont(font);
                timerLabel.setText(timeSeconds.toString());
                if(timeSeconds<=0){
                    stage.setScene(scene);
                }
            }
        }));
        timeline.play();
        tilePane.getChildren().add(timerLabel);
    }
    Scene getScene(){return scene;}
}
