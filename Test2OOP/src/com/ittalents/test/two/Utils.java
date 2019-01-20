package com.ittalents.test.two;

import java.util.*;

//TODO: REFACTOR NAMES, ADDRESSES, GOODS, SHOPS
public final class Utils {

    public static final boolean checkString(String text) {
        if (text != null && text.trim().length() > 0) {
            return true;
        }
        return false;
    }

    public static String getRandomName() {
        String[] firstNames = {"Ivan", "Stoycho", "Gergana", "Yanislav", "Minzuharka", "Pruch", "Petyr", "Stoycho",
                "Nikoleta", "Yanislav", "Petko", "Gavrail", "Radoy", "Krasimira", "Roza", "Qnica"};

        String[] lastNames = {"Trifonov", "Karatopraklieva", "Manushev", "Kostov", "Ahilesov", "Tazobedrev",
                "Miroslavova", "Mishev", "Grozeva", "Ovcharov", "Dineva", "Mitev", "Chanev", "Minkov",
                "Kolarov", "Milev"};

        return firstNames[(int) (Math.random() * firstNames.length)] + " "
                + lastNames[(int) (Math.random() * lastNames.length)];
    }

    public static String getRandomAddress() {
        String[] address = {"Bulevard Bulgaria", "Orlov Most", "Mladost", "Kriva reka",
                "Luvov Most", "Orlandovci", "Fakulteta", "Lozenec", "Hladilnika"};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        String[] street = {"Daskal Manol", "Dospat", "Kostur", "6ti septemvri", "Todor Kableshkov",
                "Milin Kamuk", "Sofronii Vrachanski", "Patriarh Evtimiy", "Evlogi i Hristo Georgievi"};

        return address[(int) (Math.random() * address.length)] + " " + numbers[(int) (Math.random() * numbers.length)] +
                " " + street[(int) (Math.random() * street.length)];
    }

    public static int getRandomPrice() {
        return (int) (Math.random() * 50 + 1);
    }

    public static int getRandomQuantity() {
        return (int) (Math.random() * 20 + 1);
    }

    public static int getRandomMoney() {
        return (int) (Math.random() * 5000 + 1);
    }

    public static int getRandomSalary() {
        return (int) (Math.random() * 2000 + 1);
    }

    public static String getRandomStock() {
        String[] goods = {"Banani", "Chereshi", "Kufteta", "Charshafi",
                "Tanciorki", "Morkovi", "Molivi", "Lakochistitel", "Jele",
                "Maratonki", "Banani", "Mecheta", "Gashti", "Chorapi", "Aerozol",
                "Muhozol", "Chereshi"};

        return goods[(int) (Math.random() * goods.length)];
    }

    public static String getRandomShopName() {
        String[] shops = {"345", "Fantastiko", "Bila", "Lidl", "Kaufland", "Pikadili", "Costco"};

        return shops[(int) (Math.random() * shops.length)];
    }

    public static Set<Stock> getRandomSetOfGoods() {
        Set<Stock> goods = new LinkedHashSet<>();
        for (int index = 0; index < (int) (Math.random() * 10) + 1; index++) {
            goods.add(new Stock(getRandomStock(), getRandomPrice()));
        }
        return goods;
    }

    public static Map<LinkedList<Shop>, Map<Stock, Integer>> getRandomDeliveries() {
        Map<LinkedList<Shop>, Map<Stock, Integer>> deliveries = new HashMap<>();

        LinkedList<Shop> shops = getRandomListOfShops();

        deliveries.put(shops, getRandomStocks(shops.size()));

        return deliveries;
    }

    private static LinkedList<Shop> getRandomListOfShops() {
        int amount = (int) (Math.random() * 10) + 1;
        LinkedList<Shop> shops = new LinkedList<>();

        for(int index = 0; index < amount; index++) {
            shops.add(new Shop(getRandomShopName()));
        }

        return shops;
    }

    private static Map<Stock, Integer> getRandomStocks(int amount) {
        Map<Stock, Integer> items = new HashMap<>();

        for(int index = 0; index < amount; index++) {
            Stock stock = new Stock(getRandomStock(), getRandomPrice());
            int stockAmount = (int) (Math.random() * 5) + 1;

            if(items.containsKey(stock)) {
                continue;
            }

            items.put(stock, stockAmount);
        }

        return items;
    }
}
