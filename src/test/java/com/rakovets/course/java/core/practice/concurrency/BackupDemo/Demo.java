package com.rakovets.course.java.core.practice.concurrency.BackupDemo;

import com.rakovets.course.java.core.practice.concurrency.backup_utility.utils.ThreadUtils1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Directory: ");
        Path source = Paths.get(in.nextLine());
        in.close();
        Path destination = Files.createDirectories(Path.of(source.getParent() + "_new"));
       // Path source = Paths.get("D:/Desktop/new");
      // Path destination = Paths.get("D:/Desktop/copy");
        ThreadUtils1 utils1 = new ThreadUtils1(source, destination);
       utils1.start();
    }
}
