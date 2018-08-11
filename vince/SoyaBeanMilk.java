package com.vince;

public class SoyaBeanMilk implements Drink {
    @Override
    public float cost() {
        return 10f;
    }

    @Override
    public String description() {
        return "纯豆浆";
    }
}
