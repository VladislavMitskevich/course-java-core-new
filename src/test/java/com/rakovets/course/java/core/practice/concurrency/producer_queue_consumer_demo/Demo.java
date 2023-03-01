package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer_demo;

import com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.utils.TreadUtils;


public class Demo {
    public static void main(String[] args) {

        TreadUtils threadConfig = new TreadUtils(2);

        threadConfig.start();
    }
}
