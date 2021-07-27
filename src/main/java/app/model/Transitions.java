package app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.PrimitiveIterator.OfDouble;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.objects.Objects;

public class Transitions {
    private static final int DEFAULT_TIME = 300;
    private Map<Objects, Objects> linkedObjects;
    private PropertyChangeSupport observable;
    private States current;
    private States next;

    public Transitions(States current, States next) {
        this.observable = new PropertyChangeSupport(this);
        this.linkedObjects = new HashMap<>();
        this.current = current;
        this.next = next;

        getLinkedObjects();
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observable.addPropertyChangeListener(pcl);
    }

    /**
     * this sub-routine allows to removes the observers to sheet class
     * 
     * @param pcl;
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        observable.removePropertyChangeListener(pcl);
    }

    private Map<Integer, Integer> getLinkedObjects() {
        for (Objects object : current.getObjects()) {
            System.out.println("x");
            for (Objects obj : next.getObjects()) {
                System.out.println("y");
                // if (object.getLinkId() == obj.getId()) {
                System.out.println("z");
                linkedObjects.put(object, obj);
                System.out.println("z");

                // }
            }
        }
        return null;
    }

    public void run(DrawingAdapterI drawingAdapter) {
        String keyX = AttributeLabel.X_POSITION.getLabel();
        String keyY = AttributeLabel.Y_POSITION.getLabel();
        for (Map.Entry<Objects, Objects> objects : linkedObjects.entrySet()) {
            String type = objects.getKey().getType();
            double currentX = 200;// objects.getKey().getX();
            double currentY = 200;// objects.getKey().getY();
            try {
                current.addObject(type, currentX, currentY);
                current.updateObject(objects.getKey().getAttributes());
            } catch (InvalidObjectTypeException e) {
                e.printStackTrace();
            }

            double nextX = 600; // objects.getValue().getX();
            double nextY = 600; // objects.getValue().getY();

            double offsetX = 100; // (nextX - currentX) / 300;
            double offsetY = 100; // (nextY - currentY) / 300;
            // drawingAdapter.reset();
            // do {
            //     drawingAdapter.reset();
            //     current.getCurrentObject().draw(drawingAdapter);

            //     currentX += offsetX;
            //     currentY += offsetY;
            //     current.getCurrentObject().setAttribute(keyX, String.valueOf(currentX));
            //     current.getCurrentObject().setAttribute(keyY, String.valueOf(currentY));
                
            //     long start = System.nanoTime();
            //     while(System.nanoTime() - start < 1000000000);                
            // } while (currentX < nextX || currentY < nextY);
            // // }

            Timer timer = new Timer();
            int begin = 0;
            int timeInterval = 500;
            timer.schedule(new TimerTask(){
                    
                int counter = 0;
                @Override
                public void run() {
                    //call the method
                    counter++;
                    if (counter >= 20){
                        timer.cancel();
                    }
                }
            }, begin, timeInterval);
        }
        
    }




    // public void reverse() {

    // }
}
