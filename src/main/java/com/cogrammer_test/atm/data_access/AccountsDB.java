package com.cogrammer_test.atm.data_access;

import java.util.*;
import com.cogrammer_test.atm.entities.*;
import com.cogrammer_test.atm.exceptions.*;
import com.cogrammer_test.atm.interfaces.*;

public class AccountsDB implements IAccountDB {
  private final ArrayList<Account> db = new ArrayList<Account>();
  private final IAccountFactory accountFactory;

  public AccountsDB(final IAccountFactory accountFactory) {
    this.accountFactory = accountFactory;
    try {
      // Seed the db
      final Random random = new Random();
      for (int i = 1; i <= 10; i++) {
        if (i < 5) {
          db.add(this.accountFactory.makeAccount(i, random.nextDouble() * 200000, "savings"));
        } else {
          db.add(this.accountFactory.makeAccount(i, random.nextDouble() * 200000, "checking"));
        }
      }
    } catch (InvalidAmountException | InvalidIdException e) {
      System.out.print(e);
    }
  }

  @Override
  public Account findById(final int id) {
    if (id > db.size()) {
      return null;
    }
    return db.get(id - 1);
  }
}
