package DecoratorPattern;

public class CoconutImpl extends Decorator {
    private Beverage beverage;

    public CoconutImpl(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int price() {
        return beverage.price() + 2;
    }

    @Override
    public String describe() {
        return beverage.describe() + "，椰果";
    }
}
