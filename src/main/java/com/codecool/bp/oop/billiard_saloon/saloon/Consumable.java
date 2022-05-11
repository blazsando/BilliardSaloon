package com.codecool.bp.oop.billiard_saloon.saloon;

public class Consumable {

    private final ConsumableType type;
    private final String name;
    private final int price;

    public Consumable(ConsumableType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public ConsumableType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
