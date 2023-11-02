package org.velezreyes.quiz.question6;


public class DrinkImple implements Drink{
    private String name;
    private double cost;
    private boolean isFizzy;

    public DrinkImple(String name, double cost, boolean isFizzy) {
        this.name = name;
        this.cost = cost;
        this.isFizzy = isFizzy;
    }
    @Override
    public String getName(){
        return name;
    }


    public double getCost() {
        return cost;
    }

    @Override
    public boolean isFizzy() {
        return isFizzy;
    }

}
