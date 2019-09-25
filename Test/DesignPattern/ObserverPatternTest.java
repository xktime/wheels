package DesignPattern;

import ObserverPattern.News;
import ObserverPattern.Reader;

public class ObserverPatternTest {
    public static void main(String[] ars) {
        News news = new News();
        //创建与注册观察者
        Reader tom = new Reader("Tom");
        news.registerObserver(tom);
        Reader jerry = new Reader("Jerry");
        news.registerObserver(jerry);
        Reader speike = new Reader("Speike");
        news.registerObserver(speike);
        //更新新闻
        news.updateNews();
        System.out.println("=======Tom再也不想看新闻了！=======");
        //删除观察者
        news.removeObserver(tom);
        //更新新闻
        news.updateNews();
    }
}
