package com.ittalents.warehouse;

import java.util.Comparator;

public class SalesAmountComparator implements Comparator<Stock> {
    public int compare(Stock stock1, Stock stock2) {
        return stock1.getSales() - stock2.getSales();
    }

    ;
}
