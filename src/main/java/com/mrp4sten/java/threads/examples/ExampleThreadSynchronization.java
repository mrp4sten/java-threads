package com.mrp4sten.java.threads.examples;

import com.mrp4sten.java.threads.examples.runnable.PrintPhrases;

public class ExampleThreadSynchronization {
  public static void main(String[] args) {
    new Thread(new PrintPhrases("Hey!", "What's up?")).start();
    new Thread(new PrintPhrases("Who", "are you?")).start();
    new Thread(new PrintPhrases("Thanks!", "dude")).start();
  }

  public synchronized static void printPhrases(String phraseOne, String phraseTwo) {
    System.out.println(phraseOne);

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }

    System.out.println(phraseTwo);
  }

}
