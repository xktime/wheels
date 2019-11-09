package DesignPattern.ObserverPattern;

public class Reader implements Observer {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("我是" + name + "；我被推送最新新闻啦！");
    }
}
