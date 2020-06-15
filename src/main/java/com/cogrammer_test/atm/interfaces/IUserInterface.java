package com.cogrammer_test.atm.interfaces;

public interface IUserInterface {
  public String requestInput(String str);

  public String requestInput();

  public void sendOutput(String str);

  public void clearOutput();
}
