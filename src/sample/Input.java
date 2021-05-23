package sample;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


import static sample.Ball.STAGE_HEIGHT;
import static sample.Ball.STAGE_WIDTH;

public class Input {
    private TilePane tilePane;
    private Scene scene;
    private javafx.scene.control.TextField textField1;
    private javafx.scene.control.Button button;
    private Label label1;

    private javafx.scene.control.TextField textField2;
    private Label label2;
    public Input() {
        tilePane = new TilePane();
        scene = new Scene(tilePane, STAGE_WIDTH, STAGE_HEIGHT);
        textField1 = new javafx.scene.control.TextField();
        button = new javafx.scene.control.Button("OK");
        label1 = new Label("Player one: PLEASE ENTER YOUR NAME: ");

        textField2 = new javafx.scene.control.TextField();
        label2 = new Label("Player two: PLEASE ENTER YOUR NAME: ");
    }

    public void setInput(Stage stage, CountDown cd, Scene scene, Player playerOne, Player playerTwo){
        javafx.scene.text.Font font = Font.font("Chalkduster", FontWeight.BOLD,36);
        label1.setFont(font);
        textField1.setFont(font);
        button.setFont(font);

        label2.setFont(font);
        textField2.setFont(font);
        tilePane.setOrientation(Orientation.VERTICAL);
        tilePane.setAlignment(Pos.CENTER);
        tilePane.getChildren().addAll(label1, textField1, label2, textField2,button);
        //each time the setOnAction is called it is replaced by the existing event handler
        //this button after pressed would both load the countdown screen and start to count down e->{load screen;count down;}
        button.setOnAction(e->{
            playerOne.getLabel().setText(textField1.getText());
            playerTwo.getLabel().setText(textField2.getText());
            stage.setScene(cd.getScene()); cd.setCountDown(stage, scene);});
    }
    public Scene getScene(){return scene;}
}
