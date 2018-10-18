package com.ittalents.warehouse;

import java.util.Set;

//TODO: EXCEPTION HANDLING
public class Distributor extends Contact {
    private static final float COMMISSION = 0.2f;
    private int money;
    private int moneyFromCurrentLoading;
    private Shop shop;

    public Distributor(String name, int money) {
        super(name);
        this.money = money;
    }

    public void setShop(Shop shop) {
        if (shop != null && this.shop == null) {
            this.shop = shop;
        } else {
            System.out.println("Cannot set shop.");
        }
    }

    public Shop getShop() {
        return this.shop;
    }

    public void loadShop(Shop shop, Set<Stock> products) {
        this.moneyFromCurrentLoading = 0;

        if (shop != null && products != null && !products.isEmpty()) {
            for (Stock stock : products) {
                int price = stock.getPrice();
                stock.setPrice(price + (int) (price * COMMISSION));
                shop.addStock(stock);
                this.moneyFromCurrentLoading += price;
                this.increaseMyMoney((int) (price * COMMISSION));
            }
        }
    }

    public void increaseMyMoney(int money) {
        if (money > 0) {
            this.money += money;
        }
    }

    public int getMoneyFromCurrentLoading() {
        return this.moneyFromCurrentLoading;
    }

    public static float getCommission() {
        return COMMISSION;
    }

    public void decreaseMyMoney(int decreaseWith) {
        if (decreaseWith > 0 && decreaseWith < this.money) {
            this.money -= decreaseWith;
        } else {
            this.money = 0;
        }
    }


}
