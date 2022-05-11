package com.codecool.bp.oop.billiard_saloon.saloon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Saloon {

    private final List<BilliardTable> tables;
    private List<Order> openOrders;
    private List<Order> paidOrders;

    public Saloon(List<BilliardTable> tables){
        this.tables = tables;
    }

    public Optional<Order> reservePoolTable(){
        return reserveTable(TableType.POOL);
    }

    public Optional<Order> reserveRexTable(){
        return reserveTable(TableType.REX);
    }

    public Optional<Order> reserveSnookerTable(){
        return reserveTable(TableType.SNOOKER);
    }

    public Optional<Order> getHighestUnpaid(){
        return getOpenOrders().stream().max(Comparator.comparing(Order::calculatePrice));
    }

    public OrderBill payOrder(Order order){
        getOpenOrders().remove(order);
        getPaidOrders().add(order);
        return order.payOrder();
    }

    private List<Order> getOpenOrders() {
        if(openOrders == null){
            this.openOrders = new ArrayList<>();
        }
        return openOrders;
    }

    private List<Order> getPaidOrders() {
        if(paidOrders == null){
            this.paidOrders = new ArrayList<>();
        }
        return paidOrders;
    }

    private Optional<Order> reserveTable(TableType type){
        Optional<BilliardTable> table = findTable(type);
        if(table.isPresent()){
            Order order = new Order(table.get());
            getOpenOrders().add(order);
            return Optional.of(order);
        }
        return Optional.empty();
    }

    private Optional<BilliardTable> findTable(TableType type){
        return tables.stream()
                .filter(table -> table.getTableType().equals(type))
                .filter(BilliardTable::isAvailable)
                .findFirst();
    }
}
