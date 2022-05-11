package com.codecool.bp.oop.billiard_saloon;

import com.codecool.bp.oop.billiard_saloon.saloon.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<BilliardTable> billiardTables = new ArrayList<>();
        billiardTables.addAll(Stream.generate(PoolTable::new).limit(4).toList());
        billiardTables.addAll(Stream.generate(RexTable::new).limit(5).toList());
        billiardTables.addAll(Stream.generate(SnookerTable::new).limit(2).toList());

        Saloon saloon = new Saloon(billiardTables);
        printHighestUnpaidTable(saloon);
        Optional<Order> snookerOpt = saloon.reserveSnookerTable();
        if(snookerOpt.isPresent()){
            Order snooker = snookerOpt.get();
            snooker.addConsumable(new Consumable(ConsumableType.FOOD, "Chicken burger", 2700));
            snooker.addConsumable(new Consumable(ConsumableType.BEVERAGE, "Martini", 1500));
            printHighestUnpaidTable(saloon);
            System.out.println("Paying the bill for table: " + snooker.getTable().getName());
            System.out.println(saloon.payOrder(snooker).toString());
            printHighestUnpaidTable(saloon);
        }
        else{
            System.out.println("No available snooker table");
        }
        for (int i = 0; i < 7; i++) {
            printReservedTable(saloon);
        }
    }

    public static void printReservedTable(Saloon saloon){
        System.out.println("Pool table reserved: " +
                saloon.reservePoolTable()
                        .map(order -> order.getTable().getName())
                        .orElse("No available table"));
    }

    public static void printHighestUnpaidTable(Saloon saloon){
        System.out.println("Highest unpaid table is: " +
                saloon.getHighestUnpaid()
                        .map(order -> order.getTable().getName())
                        .orElse("No unpaid table"));
    }
}
