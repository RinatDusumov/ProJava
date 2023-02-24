package lessonTelRan.lesson17.streamExample2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FlatMapExample {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Rinat", Arrays.asList("+23432", "+435525", "+675643")),
                new Human("Victor", Arrays.asList("+453634", "+897898", "+543364")),
                new Human("Petr", Arrays.asList("+7568765", "+5654632", "+4354622"))
        );

        List<String> phonesNumbers = new ArrayList<>();
        for (Human human : humans) {
            // добавить все номера, которые есть в коллекции (в конец)
            phonesNumbers.addAll(human.getPhones());
        }
        System.out.println(phonesNumbers);

        List<String> phonesSecondCopy = humans.stream()
                .map(human -> human.getPhones())
                .flatMap(phones -> phones.stream())
                .collect(Collectors.toList());
        System.out.println(phonesSecondCopy);
    }
}