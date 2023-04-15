//package main.java.students.rinat_dusumov.additionalTask.multithreading.task_3;
//
//import java.util.Scanner;
//class MFU implements Runnable {
//    private static volatile String text;
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(50);
//            System.out.println("Отсканированно 1, 2, 3, ");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args) {
//        Thread thread = new Thread(new MFU());
//        thread.start();
//        Scanner scr = new Scanner(System.in);
//        System.out.println("Напечатайте документ");
//        text = scr.nextLine();
//    }
//}