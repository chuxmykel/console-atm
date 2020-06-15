package com.cogrammer_test.atm.view;

import java.util.Scanner;
import com.cogrammer_test.atm.interfaces.IUserInterface;

public class ConsoleView implements IUserInterface {
  private final String defaultPrompt = "Main menu\n1. check balance\n2. withdraw\n3. deposit\n4. exit\n";

  @Override
  public String requestInput() {
    return this.requestInput(defaultPrompt);
  }

  @Override
  public String requestInput(final String str) {
    this.sendOutput(str);
    final Scanner scanner = new Scanner(System.in);
    final String result = scanner.nextLine();
    return result;
  }

  @Override
  public void sendOutput(final String str) {
    System.out.println(str);
  }

  @Override
  public void clearOutput() {
    // TODO: Work on a better implementation
    for (int i = 0; i <= 2000; i++) {
      System.out.println('\n');
    }
  }
}
