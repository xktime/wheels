package DecoratorPattern;

public class MilkyTeaImpl implements Beverage {
    @Override
    public int price() {
        return 5;
    }

    @Override
    public String describe() {
        return "奶茶";
    }
}
