package DesignPattern.DecoratorPattern;

public class BubbleImpl extends Decorator {
    private Beverage beverage;

    public BubbleImpl(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int price() {
        return beverage.price() + 1;
    }

    @Override
    public String describe() {
        return beverage.describe() + "，波霸";
    }
}
