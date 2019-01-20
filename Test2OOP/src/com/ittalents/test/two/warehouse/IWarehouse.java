package com.ittalents.test.two.warehouse;

import com.ittalents.test.two.Shop;
import com.ittalents.test.two.Stock;
import com.ittalents.test.two.Worker;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface IWarehouse {

    void loadWarehouse(Map<Stock, Integer> listOfGoods);

    void deliver(Map<LinkedList<Shop>, Map<Stock, Integer>> goods);

    List<Stock> getTheMostSellingGoods();

    List<Worker> getTheWorstWorker();

    Map<Stock, Integer> getDeficientGoods();

    void getStatistics();

    void getBalance();
}
