package com.cogrammer_test.atm.interfaces;

import com.cogrammer_test.atm.entities.Account;
import com.cogrammer_test.atm.exceptions.*;

public interface IAccountController {
  public String checkBalance(int accountId);

  public String withdraw(int accountId, double amount) throws InsufficientFundsException;

  public String deposit(int accountId, double amount) throws InvalidAmountException;

  public Account findById(int accountId);
}
