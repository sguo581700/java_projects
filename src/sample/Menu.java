package sample;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Menu {
    private TilePane tilePane;
    private Scene scene;
    private Button newGame;
    private Button endGame;
    public Menu() {
        this.tilePane = new TilePane();
        this.newGame= new Button("New Game");
        this.endGame = new Button("Exit");
        this.scene= new Scene(tilePane);
    }
    void setNewGame(Stage stage, Input input){
        Font font = Font.font("Chalkduster", FontWeight.BOLD,36);
        newGame.setFont(font);
        endGame.setFont(font);
        tilePane.setOrientation(Orientation.VERTICAL);
        tilePane.setAlignment(Pos.BOTTOM_CENTER);
        tilePane.setPrefColumns(2);
        tilePane.setVgap(10);
        tilePane.getChildren().addAll(newGame, endGame);
        newGame.setOnAction(e->stage.setScene(input.getScene()));
        endGame.setOnAction(e->{
            System.out.println("Calling stage to close...");
            stage.close();
            System.exit(0);
        });
    }
    Scene getScene(){return scene;}
}
