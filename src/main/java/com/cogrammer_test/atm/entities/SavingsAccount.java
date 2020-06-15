package com.cogrammer_test.atm.entities;

import com.cogrammer_test.atm.exceptions.*;

public class SavingsAccount extends Account {
  private static final double annualInterestRate = 3.8;

  public SavingsAccount(final int id, final double balance) throws InvalidAmountException, InvalidIdException {
    super(id, balance);
  }

  public double getMonthlyInterestRate() {
    return (SavingsAccount.annualInterestRate / 100) / 12;
  }

  public double getMonthlyInterest() {
    return balance * getMonthlyInterest();
  }
}
