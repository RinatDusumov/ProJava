package lessonTelRan.lesson17.streamExample2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MinMaxCheck {
    private static class People {
        private String name;
        private Integer age;
        private Sex sex;

        public People(String name, Integer age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            People people = (People) o;
            return Objects.equals(name, people.name)
                    && Objects.equals(age, people.age)
                    && Objects.equals(sex, people.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }
    private enum Sex {
        MAN,
        WOMAN
    }
    private static void minAndMax() {
        System.out.println("Min and Max elements");
        Collection<People> people = Arrays.asList(
                new People("Ruslan", 32, Sex.MAN),
                new People("Victor", 28, Sex.MAN),
                new People("Yana", 18, Sex.WOMAN),
                new People("Vlad", 25, Sex.MAN),
                new People("Sergei", 30, Sex.MAN),
                new People("Elena", 20, Sex.WOMAN),
                new People("Petr", 19, Sex.MAN)
        );

        People older = people.stream()
                .max((p1,p2) -> p1.getAge().compareTo(p2.getAge()))
                .get();
        People younger = people.stream()
                .min((p1,p2) -> p1.getAge().compareTo(p2.getAge()))
                .get();
        System.out.println("Older member is - " + older);
        System.out.println("Younger member is - " + younger);
    }

    public static void main(String[] args) {
        minAndMax();
    }
}