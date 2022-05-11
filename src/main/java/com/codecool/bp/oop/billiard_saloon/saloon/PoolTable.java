package com.codecool.bp.oop.billiard_saloon.saloon;

public class PoolTable extends BilliardTable{

    private static int TABLE_NUMBER = 1;

    public PoolTable(){
        super(TableType.POOL, 1200, "POOL TABLE " + TABLE_NUMBER);
        TABLE_NUMBER++;
    }

    @Override
    boolean isAvailable() {
        return !reserved;
    }
}
