package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Player {
    private static String name;
    private Label label;
    public Player() {
        label = new Label();
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    Label getLabel(){
        javafx.scene.text.Font font = Font.font("Chalkduster", FontWeight.BOLD,36);
        label.setFont(font);
        return label;}
}
