package com.ittalents.warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Worker extends Contact {
    protected int zaplata;
    protected Warehouse warehouse;
    protected List<Stock> prietiStoki;
    protected List<Stock> otpisaniStoki;

    public Worker(String name, int zaplata, Warehouse sklad) {
        super(name);
        this.setWarehouse(sklad);
        this.zaplata = zaplata;
        this.prietiStoki = new ArrayList<Stock>();
        this.otpisaniStoki = new ArrayList<Stock>();
    }

    public void addToReceived(Stock stock) {
        if (stock != null && !this.prietiStoki.contains(stock)) {
            this.prietiStoki.add(stock);
        } else {
            System.out.println("Cannot add prieta stock");
        }
    }

    public void arrangeGoodsInWarehouse(List<Stock> stokiZaPodrejdane) {
        for (Stock stock : stokiZaPodrejdane) {
            this.warehouse.addStock(stock);
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

    public List<Stock> getPrietiStoki() {
        return Collections.unmodifiableList(this.prietiStoki);
    }

    ;


}
