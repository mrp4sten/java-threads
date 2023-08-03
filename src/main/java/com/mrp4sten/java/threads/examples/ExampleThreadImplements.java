package com.mrp4sten.java.threads.examples;

import com.mrp4sten.java.threads.examples.runnable.TaskTravel;

public class ExampleThreadImplements {
  public static void main(String[] args) {
    new Thread(new TaskTravel("Mauricio Island")).start();
    new Thread(new TaskTravel("New Zeland")).start();
    new Thread(new TaskTravel("Mexico")).start();
    new Thread(new TaskTravel("Canada")).start();
  }
}
