package com.mrp4sten.java.threads.timerexample;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ExampleScheduleTaskTimer {
  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println(
            "Task do it at: " + new Date() +
                "Thread name: " + Thread.currentThread().getName());

        System.out.println("Time ends");
        timer.cancel();
      }

    }, 5000);

    System.out.println("We schedule a task for 5 more minutes");
  }
}
