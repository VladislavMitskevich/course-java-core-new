package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.publisher;

import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.exception.UserInputException;

import java.util.Queue;
import java.util.Scanner;

public class Producer implements Runnable {
    private final static int THREAD_OFF = -1;
    private final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int time = scanner.nextInt();
                if (time > THREAD_OFF) {
                    queue.add(time);
                    System.out.println("Time " + time + " add to queue");
                } else if (time == THREAD_OFF) {
                    System.out.println("End of output");
                    break;
                } else {
                    trappingException();
                    scanner.next();
                }
            } else {
                trappingException();
                scanner.next();
            }
        }
    }

    private void trappingException() {
        try {
            throw new UserInputException("Enter an positive Integer!");
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
