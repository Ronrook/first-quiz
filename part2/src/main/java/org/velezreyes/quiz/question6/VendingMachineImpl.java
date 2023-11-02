package org.velezreyes.quiz.question6;

import java.util.*;

public class VendingMachineImpl implements VendingMachine{

  private static VendingMachine instance;
  private double quarterDollarCount;
  private Map<String, DrinkImple> drinks;


  // Constructor privado
  public VendingMachineImpl() {

    this.drinks = new HashMap<>();
    drinks.put("KarenTea", new DrinkImple("KarenTea", 0.80, false));
    drinks.put("ScottCola", new DrinkImple("ScottCola", 0.75, true));

  }
  // Patrón Singleton
  public static VendingMachine getInstance() {
    if ( instance == null ) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  @Override
  public void insertQuarter(){
    this.quarterDollarCount += 0.25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException{

    if(!drinks.containsKey(name)) {
      throw new UnknownDrinkException();
    }

    DrinkImple drink = this.drinks.get(name);

    if(quarterDollarCount < 0.1 ||quarterDollarCount < drink.getCost())
        throw new NotEnoughMoneyException();

    this.quarterDollarCount = 0;
    return drink;
  }

}
