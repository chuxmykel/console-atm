package com.cogrammer_test.atm.interfaces;

import com.cogrammer_test.atm.entities.Account;
import com.cogrammer_test.atm.exceptions.*;

public interface IAccountService {
  public double checkBalance(int id);

  public double withdraw(int id, double amount) throws InsufficientFundsException;

  public double deposit(int id, double amount) throws InvalidAmountException;

  public Account findById(int id);
}
