package com.cogrammer_test.atm.exceptions;

public class InvalidAmountException extends Exception {
  /**
   * Auto Generated
   */
  private static final long serialVersionUID = 6544384218777045098L;
  private final double amount;

  public InvalidAmountException(final double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }
}
