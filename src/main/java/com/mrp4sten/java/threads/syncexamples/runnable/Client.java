package com.mrp4sten.java.threads.syncexamples.runnable;

import com.mrp4sten.java.threads.syncexamples.Bakery;

public class Client implements Runnable {
  private Bakery bakery;

  public Client(Bakery bakery) {
    this.bakery = bakery;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      bakery.eat();
    }
  }

}
