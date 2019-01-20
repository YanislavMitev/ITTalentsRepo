package com.ittalents.test.two;

import com.ittalents.test.two.warehouse.Warehouse;

import java.util.*;

public abstract class Provider extends Contact {
    protected int money;

    protected Map<Stock, Integer> boughtGoods;

    public Provider(String name, int money) {
        super(name);
        this.money = money;
        this.boughtGoods = new HashMap<>();
    }

    public abstract void buyGoods(Map<Stock, Integer> goods);

    public abstract Map<Stock, Integer> sellGoods(Warehouse warehouse);

    public void clearBoughtGoods() {
        this.boughtGoods.clear();
    }

    public Map<Stock, Integer> getBoughtGoods() {
        return Collections.unmodifiableMap(this.boughtGoods);
    }
}
