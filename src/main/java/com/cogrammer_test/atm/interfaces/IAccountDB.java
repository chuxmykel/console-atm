package com.cogrammer_test.atm.interfaces;

import com.cogrammer_test.atm.entities.Account;

public interface IAccountDB {
  public Account findById(int id);
}
