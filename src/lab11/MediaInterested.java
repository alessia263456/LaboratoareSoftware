package lab11;

public class MediaInterested implements Observer {
    private String name;

    public MediaInterested(String name) {
        this.name = name;
    }

    public void doSomeLogic(String message) {
        System.out.println("["+name + "] received update: " + message);
    }

    @Override
    public void update(String message) {
        doSomeLogic(message);
    }
}