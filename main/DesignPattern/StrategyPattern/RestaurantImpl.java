package DesignPattern.StrategyPattern;

public class RestaurantImpl {
    Peopel peopel;

    public RestaurantImpl(Peopel customer) {
        this.peopel = customer;
    }

    public void food() {
        peopel.eat();
    }
}
