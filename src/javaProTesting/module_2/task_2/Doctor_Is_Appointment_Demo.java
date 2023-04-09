package javaProTesting.module_2.task_2;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Doctor_Is_Appointment_Demo {
    private static Queue<Person> queueToTheDoctor = new ArrayDeque<>();
    static Scanner scr = new Scanner(System.in);
    public static void main(String[] args) {
        //dataInput();
        Pattern p = Pattern.compile("[a-zA-Z0-9]+[^&\\?]");
        Matcher matcher = p.matcher("one!Two@Three?Four");
        System.out.println(matcher.matches());

    }
    static void dataInput() {
        System.out.println("Напишите номер талона");
        int number = scr.nextInt();
        System.out.println("Укажите выбранное время");
        String time = scr.next();
        System.out.println("Ваше имя?");
        String name = scr.next();
        reservation(number, time, name);
    }
    static void reservation(int number, String time, String name) {
        Doctor_Is_Appointment_Demo.queueToTheDoctor.add(new Person(number, time, name));
    }
}