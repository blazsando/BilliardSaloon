package com.codecool.bp.oop.billiard_saloon.saloon;

import java.util.List;

public class OrderBill {

    private final String table;
    private final List<Consumable> consumables;
    private final int consumablePrice;
    private final int tableHours;
    private final int tablePrice;

    OrderBill(String table, List<Consumable> consumables, int consumablePrice, int tableHours, int tablePrice) {
        this.table = table;
        this.consumables = consumables;
        this.consumablePrice = consumablePrice;
        this.tableHours = tableHours;
        this.tablePrice = tablePrice;
    }

    public int getConsumablePrice() {
        return consumablePrice;
    }

    public int getTablePrice() {
        return tablePrice;
    }

    public int getTotalPrice() {
        return consumablePrice + tablePrice;
    }

    @Override
    public String toString(){
        return
                "Bill for " + table + " table reservation: \n"
                + "  consumables: " + String.join(", ", consumables.stream().map(Consumable::getName).toList()) + "\n"
                + "  price: " + consumablePrice + "\n"
                + "  table reserved for: " + tableHours + "hours\n"
                + "  price: " + tablePrice + "\n"
                + "  total price: " + tablePrice;
    }
}
