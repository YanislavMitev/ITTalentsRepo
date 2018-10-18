package com.ittalents.warehouse;

import java.util.List;

//TODO:EXCEPTION HANDLING
public class TraineeWorker extends Worker {

    public TraineeWorker(String name, int salary, Warehouse warehouse) {
        super(name, salary, warehouse);
    }

    @Override
    public void arrangeGoodsInWarehouse(List<Stock> goodsForOrdering) {
        for (Stock stock : goodsForOrdering) {
            if (Math.random() >= 0.5) {
                continue;
            }
            this.warehouse.addStock(stock);
        }
    }
}
