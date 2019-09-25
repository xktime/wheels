package ObserverPattern;

import java.util.ArrayList;

public class News implements Observable {
    ArrayList<Observer> observers;

    public News() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void updateNews() {
        notifyObserver();
    }
}
