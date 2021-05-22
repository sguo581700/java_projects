package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameEngine {
    final double STAGE_WIDTH = 640;
    final double STAGE_HEIGHT = 480;
    private Bat batL;
    private Ball ball;
    private Bat batR;
    private Pane canvas;
    private Scene scene;
    private Player player;



    public GameEngine() {
        batL = new Bat();
        ball = new Ball();
        batR = new Bat();
        canvas = new Pane();
        scene = new Scene(canvas, STAGE_WIDTH, STAGE_HEIGHT);
        player = new Player();
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
    public Player getPlayer() {
        return player;
    }
}
