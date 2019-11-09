package DesignPattern.FactoryPattern;

public class DrinkShopFactory {

    public DrinkShop createDrinkShop(String shopName) {
        if (shopName == null) {
            return null;
        }
        switch (shopName) {
            case "Coke":
                return new CokeShopImpl();
            case "Coffee":
                return new CoffeeShopImpl();
            case "MilkyTea":
                return new MilkyTeaShopImpl();
        }
        return null;
    }
}
