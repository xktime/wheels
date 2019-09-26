package DecoratorPattern;

/**
 * 装饰者类
 */
public abstract class Decorator implements Beverage {
    public abstract int price();

    public abstract String describe();
}
