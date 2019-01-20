package com.ittalents.test.two;

import com.ittalents.test.two.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Worker extends Contact {
    protected int salary;
    protected Warehouse warehouse;
    protected List<Stock> acceptedGoods;
    protected List<Stock> withdrawnGoods;

    public Worker(String name, int salary, Warehouse warehouse) {
        super(name);
        this.setWarehouse(warehouse);
        this.salary = salary;
        this.acceptedGoods = new ArrayList<>();
        this.withdrawnGoods = new ArrayList<>();
    }

    public void addToReceived(Stock stock) {
        if (stock != null && !this.acceptedGoods.contains(stock)) {
            this.acceptedGoods.add(stock);
        } else {
            //TODO: Refactor with throwing exception
            System.out.println("No stock received");
        }
    }

    public void arrangeGoodsInWarehouse(Map<Stock, Integer> goodsForArrangement) {
        for (Map.Entry<Stock, Integer> entry : goodsForArrangement.entrySet()) {
            warehouse.addStock(entry.getKey(), entry.getValue());
        }
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        if (warehouse != null) {
            this.warehouse = warehouse;
        } else {
            System.out.println("Invalid warehouse.");
        }
    }

    public List<Stock> getAcceptedGoods() {
        return Collections.unmodifiableList(this.acceptedGoods);
    }

    public List<Stock> getWithdrawnGoods(){ return Collections.unmodifiableList(this.withdrawnGoods);}

}
