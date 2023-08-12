package com.mrp4sten.java.threads.syncexamples;

import java.util.concurrent.ThreadLocalRandom;

public class ExampleProducerClient {
  public static void main(String[] args) {
    Bakery bakery = new Bakery();

    // Producer
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        bakery.bake("Bread number : #" + i);
        try {
          Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
        }
      }
    }).start();

    // Client
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        bakery.eat();
      }
    }).start();
  }

}
