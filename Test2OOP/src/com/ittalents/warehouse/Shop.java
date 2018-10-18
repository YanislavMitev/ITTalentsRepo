package com.ittalents.warehouse;

import java.util.HashMap;
import java.util.Map;

//TODO:EXCEPTION HANDLING
public class Shop extends Contact {
    private Map<Stock, Integer> goods;

    public Shop(String name) {
        super(name);
        this.goods = new HashMap<Stock, Integer>();
    }

    public void addStock(Stock stock) {
        if (stock != null && this.goods.containsKey(stock)) {
            int currentAmount = this.goods.get(stock);
            this.goods.put(stock, currentAmount + stock.getQuantity());
        } else {
            if (stock != null) {
                this.goods.put(stock, stock.getQuantity());
            } else {
                System.out.println("Invalid stock.");
            }
        }
    }


}
