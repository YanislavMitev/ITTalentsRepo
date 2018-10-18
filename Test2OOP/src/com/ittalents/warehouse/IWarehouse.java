package com.ittalents.warehouse;

import java.util.List;
import java.util.Set;

public interface IWarehouse {

    void loadWarehouse(List<Stock> listOfGoods);

    void deliver(Set<Stock> goods, Shop shop);

    List<Stock> getTheMostSellingGoods();

    List<Worker> getTheWorstWorker();

    List<Stock> getDeficientGoods();

    void getStatistics();

    void getBalance();
}
