package DesignPattern;

import DecoratorPattern.*;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Beverage beverage = new MilkyTeaImpl();
        //对奶茶对象增加装饰
        beverage = new PuddingImpl(beverage);
        beverage = new PuddingImpl(beverage);
        beverage = new CoconutImpl(beverage);
        beverage = new BubbleImpl(beverage);
        System.out.println(beverage.describe());
        System.out.println("一共" + beverage.price() + "元");
    }
}
