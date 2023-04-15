package main.java.students.rinat_dusumov.additionalTask.multithreading.task_4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecording {
    static File file = new File("C://ProJava", "Demo_text.txt");
    static Scanner scr = new Scanner(System.in);
    private static final Object lock = new Object();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        recordTread();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread_3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        recordTread();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread_2.start();
        thread_3.start();
        for (int i = 0; i < 10; i++) {
            recordTread();
        }
    }

    static void recordTread() throws IOException {
        synchronized (lock) {
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Напишите текст.");
            sb.append(scr.nextLine()).append("\n");
            fileWriter.write(String.valueOf(sb));
            fileWriter.close();
        }
    }
}