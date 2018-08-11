package com.vince;

public class SugarDecorator extends Decorator {
    public SugarDecorator(Drink drink){
        super(drink);
    }

    @Override
    public float cost() {
        return super.cost()+1.0f;
    }

    @Override
    public String description() {
        return super.description()+"糖";
    }
}
