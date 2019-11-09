package DesignPattern;

import DesignPattern.FactoryPattern.DrinkShop;
import DesignPattern.FactoryPattern.DrinkShopFactory;

public class FactoryPatternTest {
    public static void main(String[] args) {
        //创建工厂
        DrinkShopFactory drinkShopFactory = new DrinkShopFactory();
        //通过工厂获取对象
        DrinkShop coffeeShop = drinkShopFactory.createDrinkShop("Coffee");
        coffeeShop.drink();
        DrinkShop milkTeaShop = drinkShopFactory.createDrinkShop("MilkyTea");
        milkTeaShop.drink();
        DrinkShop cokeShop = drinkShopFactory.createDrinkShop("Coke");
        cokeShop.drink();
    }
}
