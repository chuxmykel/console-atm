package com.cogrammer_test.atm.entities;

import com.cogrammer_test.atm.exceptions.*;
import com.cogrammer_test.atm.interfaces.IAccountFactory;

public class AccountFactory implements IAccountFactory {
  @Override
  public Account makeAccount(final int id, final double balance, final String type)
      throws InvalidAmountException, InvalidIdException {
    try {
      if (type == "savings") {
        return new SavingsAccount(id, balance);
      }
      return new CheckingAccount(id, balance);
    } catch (InvalidAmountException | InvalidIdException e) {
      throw e;
    }
  }
}
