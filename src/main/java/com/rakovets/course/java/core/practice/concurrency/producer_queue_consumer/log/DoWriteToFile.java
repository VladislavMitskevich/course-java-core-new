package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DoWriteToFile {
    private final File log;

    public DoWriteToFile(String fileName) {
        this.log = new File(fileName);
    }

    public void write(String txt) {
        try {
            FileWriter out = new FileWriter(txt, true);
            out.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) +
                    " - " + Thread.currentThread().getName() +
                    " " + Thread.currentThread().getId() + " - " + txt + "\n");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
