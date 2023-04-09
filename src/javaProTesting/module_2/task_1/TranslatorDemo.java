package javaProTesting.module_2.task_1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class TranslatorDemo {
    static TranslatorDemo translatorDemo = new TranslatorDemo();
    Map<String, String> dictionary = new TreeMap<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        translatorDemo.dictionary.put("Word", "Слово");
        //String userChoice;
        do {
            translatorDemo.wordInput();
            System.out.println("Будете продолжать? Напишите yes или no.");
            //userChoice = scanner.next();
        } while (scanner.next().equalsIgnoreCase("yes"));
    }

    void wordInput() {
        System.out.println("Введите слово на английском языке");
        String wordFromUser = scanner.next();
        if (translatorDemo.dictionary.isEmpty()) {
            translatorDemo.addingANewWord(wordFromUser);
        } else {
            translatorDemo.wordSearch(wordFromUser);
        }
    }
    void wordSearch(String wordFromUser) {
        for (Map.Entry<String, String> word : translatorDemo.dictionary.entrySet()) {
            if (wordFromUser.equalsIgnoreCase(word.getKey())) {
                System.out.println(wordFromUser + " - " + word.getValue());
            } else {
                translatorDemo.addingANewWord(wordFromUser);
            }
        }
    }
    void addingANewWord(String inEnglish) {
        String inRussian;
        System.out.println("Этого слова в словаре нет");
        System.out.println("Напишите его перевод и он будет добавлен в словарь");
        inRussian = scanner.next();
        translatorDemo.dictionary.put(inEnglish, inRussian);
    }
}