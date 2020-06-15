package com.cogrammer_test.atm.exceptions;

public class InsufficientFundsException extends Exception {
  /**
   * Auto Generated
   */
  private static final long serialVersionUID = -7573704081107268245L;
  private final double amount;

  public InsufficientFundsException(final double amount) {
    this.amount = amount;
  }

  public String getMessage() {
    return "You cannot withdraw " + amount + ". Insufficient funds.";
  }
}
