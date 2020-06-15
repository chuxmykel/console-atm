package com.cogrammer_test.atm.controllers;

import com.cogrammer_test.atm.entities.Account;
import com.cogrammer_test.atm.exceptions.*;
import com.cogrammer_test.atm.interfaces.*;

public class AccountController implements IAccountController {
  private final IAccountService accountService;

  public AccountController(final IAccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  public String checkBalance(final int accountId) {
    final double balance = accountService.checkBalance(accountId);
    return "Your account balance is: " + balance + "\n\n";
  }

  @Override
  public String withdraw(final int accountId, final double amount) {
    try {
      final double newBalance = accountService.withdraw(accountId, amount);
      return "Please take your cash: " + amount + "...\n\n" + "Your new account balance is " + newBalance
          + "\n\nThank you for banking with us\n";
    } catch (final InsufficientFundsException e) {
      return e.getMessage();
    }
  }

  @Override
  public String deposit(final int accountId, final double amount) {
    try {
      final double newBalance = accountService.deposit(accountId, amount);
      return "Deposit successful...\n\nYour new account balance is " + newBalance + "\n\n";
    } catch (final InvalidAmountException e) {
      return e.getMessage();
    }
  }

  @Override
  public Account findById(final int accountId) {
    return accountService.findById(accountId);
  }

}
