package lessonTelRan.lesson17.streamExample2;

import java.util.List;

public class Human {
    private String name;
    private List<String> phones;

    public Human(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
