package DesignPattern.DecoratorPattern;

public class PuddingImpl extends Decorator {
    private Beverage beverage;

    public PuddingImpl(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int price() {
        return beverage.price() + 3;
    }

    @Override
    public String describe() {
        return beverage.describe() + "，布丁";
    }
}
