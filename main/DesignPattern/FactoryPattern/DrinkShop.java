package DesignPattern.FactoryPattern;

public abstract class DrinkShop {
    String shopName = null;

    public void drink() {
        System.out.println("喝" + shopName);
    }
}
