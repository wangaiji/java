package com.vince;

public abstract class Decorator implements Drink{
    private Drink drink;//要装饰的对象
    public Decorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public float cost() {
        return drink.cost();
    }

    @Override
    public String description() {
        return drink.description();
    }
}
