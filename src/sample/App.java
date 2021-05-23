package sample;

import javafx.animation.Timeline;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import static sample.Ball.STAGE_HEIGHT;
import static sample.Ball.STAGE_WIDTH;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        GameEngine gameEngine= new GameEngine();
        gameEngine.getCanvas();
        Bounds bounds = gameEngine.getCanvas().getBoundsInParent();
        Menu menu = new Menu();
        CountDown cd = new CountDown();
        Input input = new Input();
        menu.setNewGame(stage, input);
        input.setInput(stage,cd, gameEngine.getScene(), gameEngine.getPlayerOne(), gameEngine.getPlayerTwo());
        stage.setTitle("Simple Pong Game");
        stage.setWidth(STAGE_WIDTH);
        stage.setHeight(STAGE_HEIGHT);
        //set the initial position of ball
        gameEngine.getBall().getCircle().relocate(bounds.getMaxX()/2,bounds.getMaxY()/2);
        //set player name label
        gameEngine.getPlayerOne().getLabel().relocate(STAGE_WIDTH/8, 0);
        gameEngine.getPlayerTwo().getLabel().relocate(STAGE_WIDTH*6/8, 0);
        gameEngine.getPlayerOne().getScoreLabel().relocate(STAGE_WIDTH/8, 50);
        gameEngine.getPlayerTwo().getScoreLabel().relocate(STAGE_WIDTH*6/8, 50);

        //set the initial position of bats
        gameEngine.getBatL().getRectangle().relocate(bounds.getMinX(),
                (bounds.getMaxY()-gameEngine.getBatR().getRectangle().getHeight())/2);
        gameEngine.getBatR().getRectangle().relocate(bounds.getMaxX()-gameEngine.getBatR().getRectangle().getWidth(),
                (bounds.getMaxY()-gameEngine.getBatR().getRectangle().getHeight())/2);
        gameEngine.getCanvas().getChildren().addAll(gameEngine.getPlayerOne().getLabel(),
                gameEngine.getPlayerOne().getScoreLabel(),
                gameEngine.getPlayerTwo().getScoreLabel(),
                gameEngine.getPlayerTwo().getLabel(),
                gameEngine.getBall().getCircle(),
                gameEngine.getBatL().getRectangle(),
                gameEngine.getBatR().getRectangle());

        stage.setScene(menu.getScene());
        stage.show();
        gameEngine.getBatL().getAnimation(bounds).start(); //batL animation
        gameEngine.getBatR().getAnimation(bounds).start(); //batR animation
        Timeline tl=gameEngine.getBall().getTimeLine(gameEngine.getBall().getCircle(),
                gameEngine.getBatL().getRectangle(),
                gameEngine.getBatR().getRectangle(),
                bounds,
                gameEngine.getPlayerOne(),
                gameEngine.getPlayerTwo());
        tl.setCycleCount(Timeline.INDEFINITE);
        //tl.play();
        gameEngine.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.W)) {
                    gameEngine.getBatL().batVProperty().set(-300);
                }
                else if (keyEvent.getCode().equals(KeyCode.S)) {
                    gameEngine.getBatL().batVProperty().set(300);
                }
                else if (keyEvent.getCode().equals(KeyCode.UP)) {
                    gameEngine.getBatR().batVProperty().set(-300);
                }
                else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                    gameEngine.getBatR().batVProperty().set(300);
                }else if(keyEvent.getCode().equals(KeyCode.SPACE)){
                    tl.pause();
                }else if(keyEvent.getCode().equals(KeyCode.R)){
                    tl.play();
                }
            }
        });
        gameEngine.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.W)||keyEvent.getCode().equals(KeyCode.S)){
                    gameEngine.getBatL().batVProperty().set(0);
                }
                if(keyEvent.getCode().equals(KeyCode.UP)||keyEvent.getCode().equals(KeyCode.DOWN)){
                    gameEngine.getBatR().batVProperty().set(0);
                }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

}
