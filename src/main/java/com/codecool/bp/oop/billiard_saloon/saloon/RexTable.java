package com.codecool.bp.oop.billiard_saloon.saloon;

import java.time.LocalDateTime;

public class RexTable extends BilliardTable{

    private static int TABLE_NUMBER = 1;

    public RexTable(){
        super(TableType.REX, 800, "REX TABLE " + TABLE_NUMBER);
        TABLE_NUMBER++;
    }

    @Override
    boolean isAvailable() {
        return LocalDateTime.now().getHour() >= 18 && !reserved;
    }
}
