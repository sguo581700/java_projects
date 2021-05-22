package sample;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


import static sample.Ball.STAGE_HEIGHT;

public class Bat extends Shape {
    private Rectangle rectangle;
    private DoubleProperty batV;
    int x;
    int y;
    int width;
    int height;
    public Bat(){
        rectangle = new Rectangle(0,0,20,80);
        batV = new SimpleDoubleProperty();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
    //animation timer getter
    public AnimationTimer getAnimation(Bounds bounds){
        double batHeight=this.getRectangle().getHeight();
        Rectangle r = this.getRectangle();
        final AnimationTimer animationTimer= new AnimationTimer(){
            final double minY = -bounds.getMaxY()+batHeight;
            final double maxY = 800;
            final LongProperty lastUpdateTime = new SimpleLongProperty();
            @Override
            public void handle(long timestamp) {
                        if(lastUpdateTime.get()>0){
                             double elapsedSeconds = (timestamp - lastUpdateTime.get())/1_000_000_000.0;
                             double deltaY = elapsedSeconds * batV.get();
                             double oldY = r.getTranslateY();
                             double newY = Math.max(minY, Math.min(maxY, oldY + deltaY));
                             if(newY<(-STAGE_HEIGHT+batHeight)/2){newY=(-STAGE_HEIGHT+batHeight)/2;}
                             else if(newY>(STAGE_HEIGHT-batHeight)/2){newY=(STAGE_HEIGHT-batHeight)/2;}
                            r.setTranslateY(newY);
                        }
                lastUpdateTime.set(timestamp);
            }
        };
        return animationTimer;
    }

    public double getBatV() {
        return batV.get();
    }

    public DoubleProperty batVProperty() {
        return batV;
    }
}
