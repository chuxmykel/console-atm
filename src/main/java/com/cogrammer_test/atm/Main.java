package com.cogrammer_test.atm;

import com.cogrammer_test.atm.view.ConsoleView;
import com.cogrammer_test.atm.controllers.AccountController;
import com.cogrammer_test.atm.services.AccountService;
import com.cogrammer_test.atm.data_access.AccountsDB;
import com.cogrammer_test.atm.entities.AccountFactory;

class Main {
  public static void main(final String[] args) {
    final ATM atm = new ATM(new ConsoleView(),
        new AccountController(new AccountService(new AccountsDB(new AccountFactory()))));

    atm.start();
  }
}
