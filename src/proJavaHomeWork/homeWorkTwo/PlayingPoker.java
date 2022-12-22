package proJavaHomeWork.homeWorkTwo;

import java.util.Scanner;

public class PlayingPoker {
    public static void main(String[] args) {
        /* task 1
        Напишите программу, которая должна имитировать раздачу карт для игры в покер.
        Программа получает число n, задаваемое с консоли пользователем, и раздает карты на n игроков (по 5 карт каждому) из рассортированной колоды.
        Разделяйте пять карт, выданных каждому игроку, пустой строкой.
         */
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Напишите кол-во игроков");
//        int numberOfPlayers = scanner.nextInt();
//
//        SortedDeck sortedDeck = new SortedDeck(numberOfPlayers);
//        PokerTable[] players = sortedDeck.cardDistribution();
//        for (int i = 0; i < players.length; i++) {
//            System.out.println(players[1]);
//            break;
//        }

        /* task 2
        При создании нескольких экземпляров одного класса
        их можно объединить массивом с типом родительского класса.
        Объекты будут храниться по ссылке закрепленной за массивом.
         */

        /* task 3
        Найти сумму нечетных чисел в массиве
         */
//        int sum = 0;
//        int[] number = {3,4,66,42,5,12,7};
//        for (int i = 0; i < number.length; i++) {
//            if (number[i] % 2 != 0) {
//                sum+=number[i];
//            }
//        }
//        System.out.println(sum);
//
//        /* дом. работа */
//        HomeWork homeWork = new HomeWork();
//        homeWork.solutions();

        /* доп. задание */
        AdditionalTask additionalTask = new AdditionalTask();
        additionalTask.decision();
    }
}
