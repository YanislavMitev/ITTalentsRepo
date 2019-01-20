package com.ittalents.test.two;

import com.ittalents.test.two.warehouse.Warehouse;

public class Demo {
    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse("Warehouse 1", Utils.getRandomAddress());
        Warehouse warehouse2 = new Warehouse("Warehouse 2", Utils.getRandomAddress());
        Warehouse warehouse3 = new Warehouse("Warehouse 3", Utils.getRandomAddress());

        //-----------------------------------------------------------------------------
        //add 4 workers in first warehouse
        //add 5 distributors int first warehouse
        //add random shops to each distributor of warehouse 1
        addWorkersToWarehouse(warehouse1);
        addDistributorsToWarehouse(warehouse1);
        addShopsToDistributorsInWarehouse(warehouse1);

        //-----------------------------------------------------------------------------
        //add 4 workers in second warehouse
        //add 5 distributors int second warehouse
        //add random shops to each distributor of warehouse 2
        addWorkersToWarehouse(warehouse2);
        addDistributorsToWarehouse(warehouse2);
        addShopsToDistributorsInWarehouse(warehouse2);

        //-----------------------------------------------------------------------------
        //add 4 workers in third warehouse
        //add 5 distributors int third warehouse
        //add random shops to each distributor of warehouse 3
        addWorkersToWarehouse(warehouse3);
        addDistributorsToWarehouse(warehouse3);
        addShopsToDistributorsInWarehouse(warehouse3);

        //-----------------------------------------------------------------------------

        //add random amount of goods in warehouse 1
        addGoodsToWarehouse(warehouse1);

        //add random amount of goods in warehouse 2
        addGoodsToWarehouse(warehouse2);

        //add random amount of goods in warehouse 3
        addGoodsToWarehouse(warehouse3);

        warehouse1.deliver(Utils.getRandomDeliveries());
        warehouse2.deliver(Utils.getRandomDeliveries());
        warehouse3.deliver(Utils.getRandomDeliveries());

        //statistics for warehouse 1
        System.out.println("Warehouse 1");
        System.out.println("-------------------------------------------------------");
        displayStatisticsForWarehouse(warehouse1);

        //statistics for warehouse 2

        System.out.println("Warehouse 2");
        System.out.println("-------------------------------------------------------");
        displayStatisticsForWarehouse(warehouse2);

        //statistics for warehouse 3

        System.out.println("Warehouse 3");
        System.out.println("-------------------------------------------------------");
        displayStatisticsForWarehouse(warehouse3);

    }

    private static void displayStatisticsForWarehouse(Warehouse warehouse1) {
        for (Stock stock : warehouse1.getTheMostSellingGoods()) {
            System.out.println(stock.getType() + " : mocked quantity");
        }
        for (Worker worker : warehouse1.getTheWorstWorker()) {
            System.out.println(worker.getName() + " : " + worker.getAcceptedGoods());
        }
        warehouse1.getStatistics();
    }

    private static void addGoodsToWarehouse(Warehouse warehouse1) {
        for (int index = 0; index < (int) (Math.random() * 30) + 1; index++) {
            warehouse1.addStock(new Stock(Utils.getRandomStock(), Utils.getRandomPrice()), Utils.getRandomQuantity());
        }
    }

    private static void addShopsToDistributorsInWarehouse(Warehouse warehouse1) {
        for (int index = 0; index < warehouse1.getListOfDistributors().size(); index++) {
            warehouse1
                    .getListOfDistributors()
                    .get(index)
                    .setShop(new Shop(Utils.getRandomShopName()));
        }
    }

    private static void addDistributorsToWarehouse(Warehouse warehouse1) {
        for (int index = 0; index < 5; index++) {
            warehouse1.addDistributor(new Distributor(Utils.getRandomName(), Utils.getRandomMoney()));
        }
    }

    private static void addWorkersToWarehouse(Warehouse warehouse1) {
        for (int index = 0; index < 4; index++) {
            warehouse1.addWorker(new Worker(Utils.getRandomName(), Utils.getRandomSalary(), warehouse1));
        }
    }

}
