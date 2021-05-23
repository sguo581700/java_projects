package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameEngine {
    final double STAGE_WIDTH = 800;
    final double STAGE_HEIGHT = 640;
    private Bat batL;
    private Ball ball;
    private Bat batR;
    private Pane canvas;
    private Scene scene;
    private Player playerOne;
    private Player playerTwo;



    public GameEngine() {
        batL = new Bat();
        ball = new Ball();
        batR = new Bat();
        canvas = new Pane();
        scene = new Scene(canvas, STAGE_WIDTH, STAGE_HEIGHT);
        playerOne = new Player();
        playerTwo = new Player();
    }

    public Bat getBatL() {
        return batL;
    }

    public Ball getBall() {
        return ball;
    }

    public Bat getBatR() {
        return batR;
    }

    public Pane getCanvas() {
        return canvas;
    }

    public Scene getScene() {
        return scene;
    }
    public Player getPlayerOne() {
        return playerOne;
    }
    public Player getPlayerTwo() {
        return playerTwo;
    }

}
