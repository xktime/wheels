package ObserverPattern;

interface Observable {
    void registerObserver(Observer observer);//注册观察者

    void removeObserver(Observer observer);//删除观察者

    void notifyObserver();//通知观察者
}
