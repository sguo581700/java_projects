package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Ball extends Shape {
    static final int STAGE_WIDTH = 800;
    static final int STAGE_HEIGHT = 640;
    private Circle circle;

    private double ballVX=6; //horizontal velocity
    private double ballVY=6; //vertical velocity

    public Ball()  {
        circle = new Circle(10, Color.BLACK);
    }

    Circle getCircle(){return circle;}

    public Timeline getTimeLine(Circle c, Rectangle l, Rectangle r, Bounds b, Player playerOne, Player playerTwo){

        Timeline tl = new Timeline( new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                    c.setLayoutX(c.getLayoutX()+ballVX);
                        c.setLayoutY(c.getLayoutY()+ballVY);
                        //if ball reaches the end of the horizontal axis

                        if(c.getLayoutX()<=(b.getMinX()+c.getRadius())||c.getLayoutX()>=(b.getMaxX()-c.getRadius())){
                            if(c.getLayoutX()<=(b.getMinX()+c.getRadius())){
                                playerTwo.gainPoint();
                                playerTwo.getScoreLabel().setText(Integer.toString(playerTwo.getScore()));
                            }
                            if(c.getLayoutX()>=(b.getMaxX()-c.getRadius())){
                                playerOne.gainPoint();
                                playerOne.getScoreLabel().setText(Integer.toString(playerOne.getScore()));
                            }
                            c.relocate(STAGE_WIDTH/2,STAGE_HEIGHT/2);
                        }
                        //if ball reaches the end of the vertical axis
                        if(c.getLayoutY()<=(b.getMinY()+c.getRadius())||c.getLayoutY()>=(b.getMaxY()-c.getRadius())){
                            ballVY=-ballVY;
                        }
                        collisionDetection(l,r);
                    }
                }));
        return tl;
    }
    public void collisionDetection(Rectangle rectangleL, Rectangle rectangleR ){
        if(rectangleL.getBoundsInParent().intersects(this.getCircle().getBoundsInParent())||rectangleR.getBoundsInParent().intersects(this.getCircle().getBoundsInParent())){
           // if(this.getCircle().getCenterY()>rectangleL.getY())
            vReverse();
        }
    }
    private void vReverse(){
        ballVX=-ballVX;
        //ballVY=-ballVY;
    }

}
