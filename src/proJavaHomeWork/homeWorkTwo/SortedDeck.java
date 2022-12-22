package proJavaHomeWork.homeWorkTwo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortedDeck {
    private int numberOfPlayers;
    public SortedDeck(int number) {
        this.numberOfPlayers = number;
    }
    Scanner SCANNER = new Scanner(System.in);

    PokerTable[] cardDistribution() {
        Random random = new Random();
        String[] cardsOnHand = new String[5];
        String[] suit = {"крести", "пики", "бубны", "червы"};
        String[] deckOfCards = {"шесть", "семь", "восемь", "девять", "десять",
                "валет", "дама", "король", "туз"};
        PokerTable[] players = new PokerTable[numberOfPlayers];
        for (int count = 0; count < players.length; count++) {
            for (int i = 0; i < cardsOnHand.length; i++) {
                for (int j = 0; j < deckOfCards.length; j++) {
                    int number = random.nextInt(deckOfCards.length);
                    for (int suits = 0; suits < suit.length; suits++) {
                        int numberSuit = random.nextInt((suit.length));
                        cardsOnHand[i] = deckOfCards[number] + " " + suit[numberSuit];
                        for (int x = 0; x < cardsOnHand.length; x++) {
                            for (int y = 0; y < cardsOnHand.length; y++) {
                                if (cardsOnHand[x] == cardsOnHand[y]) {
                                    number = random.nextInt(deckOfCards.length);
                                    numberSuit = random.nextInt((suit.length));
                                    cardsOnHand[i] = deckOfCards[number] + " " + suit[numberSuit];
                                    if (cardsOnHand[x] == cardsOnHand[y]) {
                                        number = random.nextInt(deckOfCards.length);
                                        numberSuit = random.nextInt((suit.length));
                                        cardsOnHand[i] = deckOfCards[number] + " " + suit[numberSuit];
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Напишите имя игрока");
            String namePlayer = SCANNER.nextLine();
            players[count] = new Player(namePlayer, Arrays.toString(cardsOnHand));
        }
        return players;
    }
}
