package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateFile {
    private final File log;

    public CreateFile(String fileName) {
        this.log = new File(fileName);
    }

    public void write(String text) {
        try (FileWriter out = new FileWriter(log, true)) {
            out.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) +
                    " - " + Thread.currentThread().getName() +
                    " " + Thread.currentThread().getId() + " - " + text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
