package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.utils;

import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.publisher.Producer;
import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.subscriber.ConsumerImpl;

import java.util.Queue;
import java.util.concurrent.*;

public class TreadUtils {
    private Integer nThreads;
    private final Queue<Integer> queue;

    public TreadUtils(Integer nThreads) {
        this.nThreads = nThreads;
        this.queue = new PriorityBlockingQueue<>();
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(
                nThreads);

        Future<?> future = executor.submit(new Producer(queue));
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        for (; nThreads > 0; nThreads--) {
            executor.execute(new ConsumerImpl(queue));
        }

        executor.shutdown();
    }
}
