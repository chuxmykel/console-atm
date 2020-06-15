package com.cogrammer_test.atm.exceptions;

public class InvalidIdException extends Exception {
  /**
   * Auto Generated
   */
  private static final long serialVersionUID = 4109923356758039755L;
  private final int id;

  public InvalidIdException(final int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
