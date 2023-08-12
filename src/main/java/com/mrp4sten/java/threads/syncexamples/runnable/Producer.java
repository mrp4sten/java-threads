package com.mrp4sten.java.threads.syncexamples.runnable;

import java.util.concurrent.ThreadLocalRandom;

import com.mrp4sten.java.threads.syncexamples.Bakery;

public class Producer implements Runnable {
  private Bakery bakery;

  public Producer(Bakery bakery) {
    this.bakery = bakery;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      bakery.bake("Bread number : #" + i);
      try {
        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }
}
