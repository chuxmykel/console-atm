package com.cogrammer_test.atm.entities;

import com.cogrammer_test.atm.exceptions.*;

public class CheckingAccount extends Account {
  private static final double overdraft = 20;

  public CheckingAccount(final int id, final double balance) throws InvalidAmountException, InvalidIdException {
    super(id, balance);
  }

  public double getOverdraft() {
    return overdraft;
  }

  @Override
  public double withdraw(final double amount) throws InsufficientFundsException {
    if ((balance - amount) < -overdraft) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
    return balance;
  }
}
