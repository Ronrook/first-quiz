package org.velezreyes.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.velezreyes.quiz.question6.Drink;
import org.velezreyes.quiz.question6.NotEnoughMoneyException;
import org.velezreyes.quiz.question6.UnknownDrinkException;
import org.velezreyes.quiz.question6.VendingMachine;
import org.velezreyes.quiz.question6.VendingMachineImpl;

public class Question6Test {

  @Test
  public void canCreateVendingMachineInstance() {
    VendingMachine vm = VendingMachineImpl.getInstance();
    // Assert Not Null instance VendingMachineImpl
    assertNotNull(vm);
  }

  @Test
  public void drinkNotFree() {
    VendingMachine vm = VendingMachineImpl.getInstance();

    // Assert Exception
    Exception exception = assertThrows(NotEnoughMoneyException.class, () -> {
      vm.pressButton("ScottCola");
    });
  }

  @Test
  public void canGetScottColaFor75Cents() throws Exception {
    VendingMachine vm = VendingMachineImpl.getInstance();

    // Insert 3 quarters = 0.75
    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();

    // Order the drink
    Drink drink = vm.pressButton("ScottCola");

    // Asserts
    assertTrue(drink.isFizzy());
    assertEquals(drink.getName(), "ScottCola");
  }

  @Test
  public void machineResets() throws Exception {
    VendingMachine vm = VendingMachineImpl.getInstance();

    // Insert 3 quarters = 0.75
    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();

    // Order the drink
    Drink drink = vm.pressButton("ScottCola");
    // Assert Not Null Drink
    assertNotNull(drink);

    // Assert Exception
    Exception exception = assertThrows(NotEnoughMoneyException.class, () -> {
      vm.pressButton("ScottCola");
    });
  }

  @Test
  public void canGetKarenTeaForOneDollar() throws Exception {
    VendingMachine vm = VendingMachineImpl.getInstance();

    // Insert 3 quarters = 0.75 cents.
    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();

    // Test that KarenTea costs more than 75 cents.
    // Assert Exception
    assertThrows(NotEnoughMoneyException.class, () -> {
      vm.pressButton("KarenTea");
    });

    // One more quarter is inserted = 1.0 dollar
    vm.insertQuarter();

    // Order the drink
    Drink drink = vm.pressButton("KarenTea");
    // Asserts
    assertFalse(drink.isFizzy());
    assertEquals(drink.getName(), "KarenTea");
  }

  @Test
  public void otherDrinksUnknown() throws Exception {
    VendingMachine vm = VendingMachineImpl.getInstance();

    // Insert 4 quarters = 1.0 dollar
    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();
    vm.insertQuarter();

    // Assert Exception
    assertThrows(UnknownDrinkException.class, () -> {
      vm.pressButton("BessieBooze");
    });
  }
}
