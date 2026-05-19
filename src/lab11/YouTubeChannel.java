package lab11;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {
    private String channelName;
    private List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    public void uploadVideo(String title) {
        System.out.println("{"+ channelName + "} uploaded a new video: " + title);
        notifyObservers("{"+ channelName + "} uploaded a new video: " + title);
    }

    @Override
    public void addObserver(Observer o) {
        if(!observers.contains(o)){
            observers.add(o);
        }
        else
        {
            System.out.println("Observer already exists!");
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.contains(o)){
            observers.remove(o);
        }
        else {
            System.out.println("Observer does not exist!");
        }
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer o : observers){
            o.update(message);
        }
    }
}