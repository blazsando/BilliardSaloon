package com.codecool.bp.oop.billiard_saloon.saloon;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Consumable> consumables;
    private final BilliardTable table;
    private final LocalDateTime startReservation;
    private LocalDateTime endReservation;


    Order(BilliardTable billiardTable){
//        for test purposes
        startReservation = LocalDateTime.now().minusHours(5);
//        startReservation = LocalDateTime.now();
        table = billiardTable;
        table.reserve();
    }

    public BilliardTable getTable(){
        return table;
    }

    public void addConsumable(Consumable consumable){
        if(consumables == null){
            consumables = new ArrayList<>();
        }
        consumables.add(consumable);
    }

    OrderBill payOrder(){
        table.release();
        endReservation = LocalDateTime.now();
        return calculateBill();
    }

    int calculatePrice(){
        return calculateBill().getTotalPrice();
    }

    private OrderBill calculateBill(){
        int consumablePrice = consumables.stream().map(Consumable::getPrice).reduce(0, Integer::sum);
        int hours = (int) (Duration.between(startReservation, LocalDateTime.now()).toHours());
        int tablePrice = hours * table.getPricePerHour();
        return new OrderBill(table.getName(), consumables, consumablePrice, hours, tablePrice);
    }
}
