package com.codecool.bp.oop.billiard_saloon.saloon;

import java.time.LocalDateTime;

public class SnookerTable extends BilliardTable{

    private static int TABLE_NUMBER = 1;

    public SnookerTable(){
        super(TableType.SNOOKER, 1600, "SNOOKER TABLE " + TABLE_NUMBER);
        TABLE_NUMBER++;
    }

    @Override
    boolean isAvailable() {
        return LocalDateTime.now().getHour() >= 18 && !reserved;
    }
}
