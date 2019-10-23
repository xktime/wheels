package ObserverPattern;

import java.util.ArrayList;

public class News implements Observable {
    ArrayList<Observer> observers;

    public News() {
        observers = new ArrayList<>();
    }

    /**
     * 往观察者列表里增加观察者
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 遍历观察者列表通知观察者
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * 更新新闻通知观察者
     */
    public void updateNews() {
        notifyObserver();
    }
}
