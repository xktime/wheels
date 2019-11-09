package DesignPattern;

import DesignPattern.StrategyPattern.AmericanImpl;
import DesignPattern.StrategyPattern.ChineseImpl;
import DesignPattern.StrategyPattern.RestaurantImpl;

public class StrategyPatternTest {
    public static void main(String[] args) {
        //变量命名前面的v表示variable，这么命名是因为不清楚Chinese这种名词首字母在小驼峰情况下应该怎么搞...
        RestaurantImpl vChineseCustomer = new RestaurantImpl(new ChineseImpl());
        vChineseCustomer.food();
        RestaurantImpl vAmericanCustomer = new RestaurantImpl(new AmericanImpl());
        vAmericanCustomer.food();
    }
}
