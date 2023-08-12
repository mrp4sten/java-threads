package com.mrp4sten.java.threads.syncexamples;

import com.mrp4sten.java.threads.syncexamples.runnable.Baker;
import com.mrp4sten.java.threads.syncexamples.runnable.Client;

public class ExampleProducerClient {
  public static void main(String[] args) {
    Bakery bakery = new Bakery();
    new Thread(new Baker(bakery)).start();
    new Thread(new Client(bakery)).start();
  }

}
