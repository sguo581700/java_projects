package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Player {
    private static String name;
    private int score=0;
    private Label label;
    private Label scoreLabel;
    public Player() {
        label = new Label();
        scoreLabel = new Label();
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
    void gainPoint(){score = score+1;}
    Label getScoreLabel(){
        javafx.scene.text.Font font = Font.font("Chalkduster", FontWeight.BOLD,36);
        scoreLabel.setFont(font);
        return scoreLabel;
    }
    void setScoreZero(){score=0;}
    int getScore(){return score;}
}
