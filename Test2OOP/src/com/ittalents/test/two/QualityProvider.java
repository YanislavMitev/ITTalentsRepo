package com.ittalents.test.two;

import com.ittalents.test.two.warehouse.Warehouse;

import java.util.Map;

//TODO: EXCEPTION HANDLING
public final class QualityProvider extends Provider {
    private static final float PERCENT = 0.3f;

    public QualityProvider(String name, int money) {
        super(name, money);
    }

    @Override
    public void buyGoods(Map<Stock, Integer> goods) {
//        if (goods != null) {
//            for (Stock stock : goods) {
//                this.boughtGoods.add(new Stock(stock.getType(),
//                        (int) (stock.getPrice() * PERCENT),
//                        Warehouse.DEFAULT_QUANTITY));
//            }
//        } else {
//            System.out.println("Invalid list of stoki.");
//            return;
//        }
    }

    @Override
    public Map<Stock, Integer> sellGoods(Warehouse warehouse) {
        //No-op
        return null;
    }
}
