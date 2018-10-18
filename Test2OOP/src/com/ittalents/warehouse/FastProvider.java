package com.ittalents.warehouse;

import java.util.List;

//TODO: EXCEPTION HANDLING
public final class FastProvider extends Provider {
    private static final float PERCENT = 0.15f;
    private static final float PERCENT_OF_LOSS = 0.1f;

    public FastProvider(String name, int money) {
        super(name, money);
    }

    @Override
    public void buyGoods(List<Stock> goods) {
        if (goods != null) {
            for (Stock stock : goods) {
                if (Math.random() <= PERCENT_OF_LOSS) {
                    continue;
                }
                this.boughtGoods.add(new Stock(stock.getType(),
                        (int) (stock.getPrice() * PERCENT),
                        Warehouse.DEFAULT_QUANTITY));
            }
        } else {
            System.out.println("Invalid list of goods.");
            return;
        }
    }
}
