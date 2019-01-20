package com.ittalents.test.two.worker;

import com.ittalents.test.two.Stock;
import com.ittalents.test.two.warehouse.Warehouse;

import java.util.Map;

//TODO:EXCEPTION HANDLING
public class TraineeWorker extends Worker {

    public TraineeWorker(String name, int salary, Warehouse warehouse) {
        super(name, salary, warehouse);
    }

    @Override
    public void arrangeGoodsInWarehouse(Map<Stock, Integer> goodsForArrangement) {
        for (Map.Entry<Stock, Integer> entry : goodsForArrangement.entrySet()) {
            if (Math.random() >= 0.5) {
                continue;
            }
            warehouse.addStock(entry.getKey(), entry.getValue());
        }
    }
}
