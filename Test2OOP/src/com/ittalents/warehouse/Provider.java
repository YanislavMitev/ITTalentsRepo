package com.ittalents.warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Provider extends Contact {
    private int money;

    protected List<Stock> boughtGoods;

    public Provider(String name, int money) {
        super(name);
        this.money = money;
        this.boughtGoods = new ArrayList<>();
    }

    public abstract void buyGoods(List<Stock> goods);

    public void increaseMyMoney(int money) {
        if (money > 0) {
            this.money += money;
        }
    }

    public void clearBoughtGoods() {
        this.boughtGoods.clear();
    }

    public List<Stock> getBoughtGoods() {
        return Collections.unmodifiableList(this.boughtGoods);
    }
}
