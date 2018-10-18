package com.ittalents.warehouse;

//TODO:EXCEPTION HANDLING
public class Stock {
    private static final int DEFAULT_PRICE = 5;
    private static final String DEFAULT_TYPE = "Bread";

    private String type;
    private int price;
    private int quantity;
    private int numberOfSales;

    public Stock(String type, int price, int quantity) {
        this.setType(type);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.numberOfSales = 0;
    }

    public void increaseSales() {
        this.numberOfSales++;
    }

    private void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Invalid quantity. Assigning to 0.");
            this.quantity = 0;
        }
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price. Assigning default.");
            this.price = DEFAULT_PRICE;
        }
    }

    private void setType(String type) {
        if (type != null && type.trim().length() > 0) {
            this.type = type;
        } else {
            System.out.println("Invalid type. Assigning default.");
            this.type = DEFAULT_TYPE;
        }
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getSales() {
        return this.numberOfSales;
    }

    @Override
    public int hashCode() {
        return this.type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Stock stock;
        if (obj instanceof Stock) {
            stock = (Stock) obj;
            if (this.getType().equals(stock.getType())) {
                return true;
            }
        }
        return false;
    }
}
