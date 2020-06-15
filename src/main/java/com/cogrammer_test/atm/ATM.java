package com.cogrammer_test.atm;

import com.cogrammer_test.atm.entities.Account;
import com.cogrammer_test.atm.exceptions.*;
import com.cogrammer_test.atm.interfaces.*;

public class ATM {
  private int accountId;
  private final IUserInterface ui;
  private final IAccountController accountController;

  public ATM(final IUserInterface ui, final IAccountController accountController) {
    this.ui = ui;
    this.accountController = accountController;
  }

  public void start() {
    final Account account = login();
    this.accountId = account.getId();
    while (true) {
      final String input = ui.requestInput();
      this.listen(input);
    }
  }

  private void delay(final int ms) {
    try {
      Thread.sleep(ms);
      ui.clearOutput();
    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private Account login() {
    try {
      final int id = Integer.parseInt(ui.requestInput("Please enter your account ID to use this ATM\n").trim());
      final Account account = accountController.findById(id);
      if (account == null) {
        ui.clearOutput();
        ui.sendOutput("Account with ID: " + id + " not found. Please provide a valid account ID\n");
        delay(4000);
        return login();
      }
      return account;
    } catch (final NumberFormatException e) {
      ui.clearOutput();
      ui.sendOutput("Please provide a valid input");
      delay(3000);
      return login();
    }
  }

  private void listen(final String input) {
    try {
      switch (Integer.parseInt(input)) {
        case 1: {
          ui.clearOutput();
          ui.sendOutput(accountController.checkBalance(accountId));
          delay(3000);
          break;
        }

        case 2: {
          ui.clearOutput();
          try {
            final double amount = Double.parseDouble(ui.requestInput("How much do you want to withdraw?\n"));
            ui.clearOutput();
            ui.sendOutput(accountController.withdraw(accountId, amount));
            delay(3000);
          } catch (final InsufficientFundsException e) {
            ui.sendOutput(e.getMessage());
            delay(3000);
          } catch (final NumberFormatException e) {
            ui.clearOutput();
            ui.sendOutput("Please provide a valid input");
            delay(3000);
            break;
          }
          break;
        }

        case 3: {
          ui.clearOutput();
          try {
            final double amount = Double.parseDouble(ui.requestInput("How much do you want to deposit?\n"));
            ui.clearOutput();
            ui.sendOutput(accountController.deposit(accountId, amount));
            delay(4000);
          } catch (final InvalidAmountException e) {
            ui.clearOutput();
            ui.sendOutput(e.getMessage());
            delay(3000);
          } catch (final NumberFormatException e) {
            ui.clearOutput();
            ui.sendOutput("Please provide a valid input");
            delay(3000);
            break;
          }
          break;
        }

        case 4: {
          ui.clearOutput();
          start();
          break;
        }

        default: {
          ui.clearOutput();
          ui.sendOutput("Please provide a valid input");
          delay(3000);
          break;
        }
      }
    } catch (final NumberFormatException e) {
      ui.clearOutput();
      ui.sendOutput("Please provide a valid input");
      delay(2000);
    }
  }
}
