package com.ittalents.test.two;

import java.util.HashMap;
import java.util.Map;

//TODO:EXCEPTION HANDLING
public class Shop extends Contact {
    private Map<Stock, Integer> goods;

    public Shop(String name) {
        super(name);
        this.goods = new HashMap<>();
    }

    public void addStock(Stock stock, Integer quantity) {
        if (stock != null && this.goods.containsKey(stock)) {
            int currentAmount = this.goods.get(stock);
            this.goods.put(stock, currentAmount + quantity);
        } else {
            if (stock != null) {
                this.goods.put(stock, quantity);
            } else {
                System.out.println("Invalid stock.");
            }
        }
    }

    public int getQuantityOf(Stock stock) {
        if(goods.containsKey(stock)) {
            return goods.get(stock);
        }
        return 0;
    }

}
