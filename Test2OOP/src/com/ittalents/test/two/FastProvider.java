package com.ittalents.test.two;

import com.ittalents.test.two.warehouse.Warehouse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//TODO: EXCEPTION HANDLING
public final class FastProvider extends Provider {
    private static final float PERCENT = 0.15f;
    private static final float PERCENT_OF_LOSS = 0.1f;

    public FastProvider(String name, int money) {
        super(name, money);
    }

    @Override
    public void buyGoods(Map<Stock, Integer> goods) {
        if(goods == null) return; //throw exception

        for(Map.Entry<Stock, Integer> entry : goods.entrySet()){
            this.money -= entry.getKey().getPrice() * entry.getValue();
            this.boughtGoods.put(entry.getKey(), entry.getValue());
        }

    }

    @Override
    public Map<Stock, Integer> sellGoods(Warehouse warehouse) {
        if(warehouse == null) return null;

        for(Map.Entry<Stock, Integer> entry : this.boughtGoods.entrySet()){
            int priceOfGoods = entry.getKey().getPrice() * entry.getValue();
            int addedValue = (int) (priceOfGoods * PERCENT);

            if(warehouse.getEarnings() - priceOfGoods <= 0){
                System.out.println("Not enough money.");
                break;
            }
            warehouse.decreaseMyMoney(priceOfGoods + addedValue);
        }
        Map<Stock, Integer> copyGoods = new HashMap<>(this.boughtGoods);
        this.clearBoughtGoods();

        return copyGoods;
    }
}
