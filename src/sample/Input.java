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
    private javafx.scene.control.TextField textField;
    private javafx.scene.control.Button button;
    private Label label;
    public Input() {
        tilePane = new TilePane();
        scene = new Scene(tilePane, STAGE_WIDTH, STAGE_HEIGHT);
        textField = new javafx.scene.control.TextField();
        button = new javafx.scene.control.Button("OK");
        label = new Label("PLEASE ENTER YOUR NAME: ");
    }

    public void setInput(Stage stage, CountDown cd, Scene scene, Player player){
        javafx.scene.text.Font font = Font.font("Chalkduster", FontWeight.BOLD,36);
        button.setFont(font);
        label.setFont(font);
        textField.setFont(font);
        tilePane.setOrientation(Orientation.VERTICAL);
        tilePane.setAlignment(Pos.CENTER);
        tilePane.getChildren().addAll(label, textField,button);
        //each time the setOnAction is called it is replaced by the existing event handler
        //this button after pressed would both load the countdown screen and start to count down e->{load screen;count down;}
        button.setOnAction(e->{
            player.getLabel().setText(textField.getText());
            stage.setScene(cd.getScene()); cd.setCountDown(stage, scene);});
    }
    public Scene getScene(){return scene;}
}
