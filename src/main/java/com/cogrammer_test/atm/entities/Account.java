package com.cogrammer_test.atm.entities;

import java.util.Date;
import com.cogrammer_test.atm.exceptions.*;

public class Account {
  private int id;
  protected double balance;
  private final Date dateCreated = new Date();

  public Account(final int id, final double balance) throws InvalidAmountException, InvalidIdException {
    try {
      this.setId(id);
      this.setBalance(balance);
    } catch (InvalidIdException | InvalidAmountException e) {
      throw e;
    }
  }

  public int getId() {
    return id;
  }

  public double getBalance() {
    return balance;
  }

  public Date getDateCreated() {
    return (Date) dateCreated.clone();
  }

  private void setId(final int id) throws InvalidIdException {
    if (id < 1) {
      throw new InvalidIdException(id);
    }
    this.id = id;
  }

  private void setBalance(final double balance) throws InvalidAmountException {
    if (balance < 0) {
      throw new InvalidAmountException(balance);
    }
    this.balance = balance;
  }

  public double withdraw(final double amount) throws InsufficientFundsException {
    if (this.balance - amount < 0) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
    return balance;
  }

  public double deposit(final double amount) throws InvalidAmountException {
    if (amount < 1) {
      throw new InvalidAmountException(amount);
    }
    balance += amount;
    return balance;
  }
}
