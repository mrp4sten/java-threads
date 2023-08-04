package com.mrp4sten.java.threads.examples.runnable;

import static com.mrp4sten.java.threads.examples.ExampleThreadSynchronization.*;

public class PrintPhrases implements Runnable {

  private String phraseOne;
  private String phraseTwo;

  public PrintPhrases(String phraseOne, String phraseTwo) {
    this.phraseOne = phraseOne;
    this.phraseTwo = phraseTwo;
  }

  @Override
  public void run() {
    printPhrases(phraseOne, phraseTwo);
  }

}
