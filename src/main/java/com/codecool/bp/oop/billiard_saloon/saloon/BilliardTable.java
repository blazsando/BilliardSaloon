package com.codecool.bp.oop.billiard_saloon.saloon;

public abstract class BilliardTable {

    private final TableType tableType;
    private final int pricePerHour;
    private final String name;
    boolean reserved;

    BilliardTable(final TableType tableType, final int pricePerHour, final String name) {
        this.tableType = tableType;
        this.pricePerHour = pricePerHour;
        this.name = name;
    }

    public TableType getTableType() {
        return tableType;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public String getName() {
        return name;
    }

    abstract boolean isAvailable();

    void reserve(){
        reserved = true;
    }

    void release(){
        reserved = false;
    }
}
