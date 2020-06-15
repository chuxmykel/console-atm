package com.cogrammer_test.atm.interfaces;

import com.cogrammer_test.atm.entities.Account;
import com.cogrammer_test.atm.exceptions.*;

public interface IAccountFactory {
  public Account makeAccount(int id, double balance, String type) throws InvalidAmountException, InvalidIdException;
}
