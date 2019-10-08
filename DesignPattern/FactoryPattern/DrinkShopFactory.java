package FactoryPattern;

public class DrinkShopFactory {

    public DrinkShop createDrinkShop(String shopName) {
        if (shopName.equals("Coke")) {
            return new CokeShop();
        } else if (shopName.equals("Coffee")) {
            return new CokeShop();
        } else if (shopName.equals("MilkTea")) {
            return new CokeShop();
        }
        return null;
    }
}
