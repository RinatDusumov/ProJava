package lessonTelRan.array.lesson5;

import java.util.Arrays;

public class Deal {
    public static void main(String[] args) {
        // часть 1 - инициализация переменных
        int cardsPerPlayer = 5;
        int players = 5;
        String[][] playersCard = new String[players][cardsPerPlayer];
        String[] suits = {"Пики", "Бубны", "Червы", "Крести"};
        String[] rank = {
                "2","3","4","5","6","7","8","9","10",
                "Валет", "Королева", "Король", "Туз"
        };
        int n = suits.length * rank.length; // кол-во карт

        // часть 2 - инициализация колоды
        String[] deck = new String[n];
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = rank[i] + " " + suits[i];
            }
        }
        System.out.println(Arrays.toString(deck));

        // часть 3 - перетасовка колоды
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i)); // случайная карта
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        System.out.println(Arrays.toString(deck));

        // часть 4 - перетасованная колода выводится на экран
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < players; j++) {
                playersCard[j][i] = deck[i * cardsPerPlayer + j];
                System.out.println(" Player " + j + " card " + playersCard[j][i]);
            }
        }
        for (int i = 0; i < players; i++) {
            System.out.println();
            System.out.println("Player " + (i + 1));
            for (int j = 0; j < cardsPerPlayer; j++) {
                System.out.print(playersCard[i][j] + " ");
            }
        }
    }
}