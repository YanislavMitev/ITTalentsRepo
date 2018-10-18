package com.ittalents.warehouse;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//TODO: EXCEPTION HANDLING
public class Warehouse extends Contact implements IWarehouse {
    private static final int STARTING_EARNINGS = 10_000;
    public static final int DEFAULT_QUANTITY = 15;

    private String address;
    private int earnings;
    private int moneySpent;
    private List<Provider> providers;
    private List<Worker> workers;
    private List<Distributor> distributors;
    private Map<Stock, Integer> goods;

    public Warehouse(String name, String address) {
        super(name);
        this.address = address;
        this.earnings = STARTING_EARNINGS;
        this.moneySpent = 0;
        this.providers = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.distributors = new ArrayList<>();
        this.goods = new HashMap<>();
    }


    public List<Distributor> getListOfDistributors() {
        return Collections.unmodifiableList(this.distributors);
    }

    public void addWorker(Worker worker) {
        if (worker != null && !this.workers.contains(worker)) {
            this.workers.add(worker);
        } else {
            System.out.println("Cannot add worker.");
        }
    }

    public void addDistributor(Distributor distributor) {
        if (distributor != null && !this.distributors.contains(distributor)) {
            this.distributors.add(distributor);
        } else {
            System.out.println("Cannot add distributor.");
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        if (address != null && address.trim().length() > 0) {
            this.address = address;
        } else {
            this.address = "";
            System.out.println("Invalid address.");
        }
    }

    public int getEarnings() {
        return this.earnings;
    }

    public void setEarnings(int earnings) {
        if (earnings > 0) {
            this.earnings = earnings;
        } else {
            System.out.println("Negative earnings. Assigning default = 0.");
            this.earnings = 0;
        }
    }

    @Override
    public void loadWarehouse(List<Stock> listOfGoods) {
        if (listOfGoods != null) {
            if (this.providers != null && !this.providers.isEmpty()) {
                Provider provider = this.providers.get((int) (Math.random() * this.providers.size()));
                provider.buyGoods(listOfGoods);
                Worker worker = this.workers.get((int) (Math.random() * this.providers.size()));

                for (Stock stock : provider.getBoughtGoods()) {
                    worker.addToReceived(stock);
                    provider.increaseMyMoney(stock.getPrice());
                    this.decreaseMyMoney(stock.getPrice());
                    this.moneySpent += stock.getPrice();
                }
                worker.arrangeGoodsInWarehouse(worker.getPrietiStoki());
                provider.clearBoughtGoods();
            } else {
                System.out.println("list of providers = NULL or list of providers is empty.");
            }
        } else {
            System.out.println("Invalid list sys goods");
        }
    }

    public void addStock(Stock stock) {
        if (stock != null) {
            if (this.goods.containsKey(stock)) {
                int stockId = this.goods.get(stock);
                this.goods.put(stock, ++stockId);
            } else {
                this.goods.put(stock, 1);
            }
        } else {
            System.out.println("Invalid stock.");
        }
    }

    @Override
    public void deliver(Set<Stock> goods, Shop shop) {
        Distributor distributor = this.distributors.get((int) (Math.random() * this.distributors.size()));
        Worker worker = this.workers.get((int) (Math.random() * this.workers.size()));
        distributor.loadShop(shop, goods);

        for (Stock stock : goods) {
            this.goods.put(stock, this.goods.get(stock) - stock.getQuantity());
            worker.otpisaniStoki.add(stock);

            int increaseWith = distributor.getMoneyFromCurrentLoading() -
                    (int) (distributor.getMoneyFromCurrentLoading() * Distributor.getCommission());

            this.increaseMyMoney(increaseWith);
            distributor.decreaseMyMoney(increaseWith);
            stock.increaseSales();
        }
    }

    @Override
    public List<Stock> getTheMostSellingGoods() {
        List<Stock> theMostSellingStock = new ArrayList<>();
        for (Entry<Stock, Integer> entry : this.goods.entrySet()) {
            theMostSellingStock.add(entry.getKey());
        }
        List<Stock> stream = theMostSellingStock
                .stream()
                .sorted((stock1, stock2) -> stock2.getSales() - stock1.getSales())
                .limit(5)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(stream);
    }

    @Override
    public List<Worker> getTheWorstWorker() {
        List<Worker> worstWorkers = new ArrayList<>();
        worstWorkers.addAll(this.workers);

        List<Worker> stream = worstWorkers.stream()
                .sorted(Comparator.comparingInt(worker -> worker.getPrietiStoki().size()))
                .limit(3)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(stream);
    }

    @Override
    public List<Stock> getDeficientGoods() {
        List<Stock> deficientGoods = new ArrayList<>();
        for (Entry<Stock, Integer> entry : this.goods.entrySet()) {
            if (entry.getKey().getQuantity() < 10) {
                deficientGoods.add(entry.getKey());
            }
        }

        deficientGoods.sort(Comparator.comparingInt(Stock::getQuantity));

        return Collections.unmodifiableList(deficientGoods);
    }

    @Override
    public void getStatistics() {

        for (Distributor d : this.distributors) {
            if (d != null) {
                System.out.println(d.getName() + " have earned " + d.getMoneyFromCurrentLoading() + " money.");
            } else {
                System.out.println("NULL DISTRIBUTOR, BREAKING...");
                break;
            }
        }
    }

    @Override
    public void getBalance() {
        System.out.println("Money spent on goods: " + this.moneySpent);
        System.out.println("Current balance: " + this.getEarnings());
    }

    public void decreaseMyMoney(int money) {
        if (money > 0 && money < this.earnings) {
            this.earnings -= money;
        }
    }

    public void increaseMyMoney(int money) {
        if (money > 0) {
            this.earnings += money;
        }
    }
}
