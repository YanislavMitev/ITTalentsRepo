package com.ittalents.warehouse;

import java.util.List;

//TODO: EXCEPTION HANDLING
public final class QualityProvider extends Provider {
    private static final float PERCENT = 0.3f;

    public QualityProvider(String name, int money) {
        super(name, money);
    }

    @Override
    public void buyGoods(List<Stock> goods) {
        if (goods != null) {
            for (Stock stock : goods) {
                this.boughtGoods.add(new Stock(stock.getType(),
                        (int) (stock.getPrice() * PERCENT),
                        Warehouse.DEFAULT_QUANTITY));
            }
        } else {
            System.out.println("Invalid list of stoki.");
            return;
        }
    }
}
