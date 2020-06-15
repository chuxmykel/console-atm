package com.cogrammer_test.atm.services;

import com.cogrammer_test.atm.entities.Account;
import com.cogrammer_test.atm.exceptions.*;
import com.cogrammer_test.atm.interfaces.*;

public class AccountService implements IAccountService {
  private final IAccountDB accountDB;

  public AccountService(final IAccountDB accountsDB) {
    this.accountDB = accountsDB;
  }

  @Override
  public double checkBalance(final int id) {
    final Account account = accountDB.findById(id);
    return account.getBalance();
  }

  @Override
  public double withdraw(final int id, final double amount) throws InsufficientFundsException {
    final Account account = accountDB.findById(id);
    try {
      return account.withdraw(amount);
    } catch (final InsufficientFundsException e) {
      throw e;
    }
  }

  @Override
  public double deposit(final int id, final double amount) throws InvalidAmountException {
    final Account account = accountDB.findById(id);
    try {
      return account.deposit(amount);
    } catch (final InvalidAmountException e) {
      throw e;
    }
  }

  @Override
  public Account findById(final int id) {
    final Account account = accountDB.findById(id);
    return account;
  }

}
