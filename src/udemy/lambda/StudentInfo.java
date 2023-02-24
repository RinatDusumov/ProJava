package udemy.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Самый короткий вариант написания лямбда выражения: stud -> stud.avgGrade > 8.5
 * Более полный вариант написания лямбда выражения: (Student stud) -> {return stud.avgGrade > 8.5;}
 * В лямбда выражении оператор стрелка разделяет параметры метода и тело метода
 *
 * В лямбда выражении справа от оператора стрелка находится тело метода,
 * которое было бы у метода соответствующего класса,
 * имплементировавшего наш интерфейс с единственным методом.
 *
 * Вы можете использовать смешанный вариант написания лямбда выражения:
 * слева от оператора стрелка писать короткий вариант, справа - полный.
 * Или наоборот.
 *
 * Если используете полный вариант написания для части лямбда выражения
 * справа от стрелки, то вы должны использовать слово return и знак ';'
 *
 * Левая часть лямбда выражения может быть написана в краткой форме,
 * если метод интерфейса принимает только 1 параметр. Даже если метод
 * интерфейса принимает 1 параметр, но в лямбда выражении вы хотите
 * писать данный параметр используя его тип данных, тогда уже вы
 * должны писать левую часть лямбда выражении в скобках.
 *
 * Если в правой части лямбда выражения вы пишите более одного
 * statement-a (более одного действия), то вы должны использовать его полный вариант написания.
 *
 * Если у метода нет параметра то нужно оставлять пустые скобки
 * () -> 8
 *
 * Лямбда выражения работают с интерфейсом, в котором есть только один
 * абстрактный метод. Такие интерфейсы называются функциональными
 * интерфейсами, т.е. интерфейсами, пригодными для функционального
 * программирования.
 */
public class StudentInfo {
    void testStudents(ArrayList<Student> al, StudentChecks sc) {
        for(Student s : al) {
            if(sc.check(s)) {
                System.out.println(s);
            }
        }
    }
    public static void main(String[] args) {
        Student st1 = new Student("Inan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Piotr", 'm', 35, 4, 7.0);
        Student st5 = new Student("Marina", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
        info.testStudents(students, new CheckOverGrade());
        System.out.println("--------------");

        info.testStudents(students, new StudentChecks() { /** создание анонимного класса */
            @Override
            public boolean check(Student s) {
                return s.age < 30;
            }
        });
        System.out.println("---------------");

        info.testStudents(students, (Student s) -> {return s.age < 30;});
        info.testStudents(students, (Student s) -> {return s.avgGrade < 30;});
        
        info.testStudents(students, s -> s.avgGrade > 8);
        info.testStudents(students, (Student s) -> s.avgGrade < 5);

        info.testStudents(students, p -> {
            System.out.println("hello");
            return p.avgGrade > 8;
        });

        /** Функциональный интерфейс Predicate<T> и его методы */
        Predicate<Student> p1 = student -> student.avgGrade > 7.5;
        Predicate<Student> p2 = student -> student.sex == 'm';
        /** метод and() помогает объединить две проверки
         * or() выводит тех у кого верно одно из условий
         * negate() - отрицание проверки p1 */
        info.testStudents(students, (StudentChecks) p1.and(p2));


//        info.printStudentsOverGrade(students, 8);
//        System.out.println("---------------");
//        info.printStudentsUnderAge(students, 30);
//        System.out.println("---------------");
//        info.printStudentsMixCondition(students,20,9.5,'f');
    }
    void printStudentsOverGrade (ArrayList<Student> al, double grade) {
        for (Student s : al) {
            if (s.avgGrade > grade) {
                System.out.println(s);
            }
        }
    }
    void printStudentsUnderAge (ArrayList<Student> al, int age) {
        for (Student s : al) {
            if (s.age < age) {
                System.out.println(s);
            }
        }
    }
    void printStudentsMixCondition (ArrayList<Student> al, int age, double grade, char sex) {
        for (Student s : al) {
            if (s.age > age && s.avgGrade < grade && s.sex == sex) {
                System.out.println(s);
            }
        }
    }
}
interface StudentChecks {
    boolean check(Student s);
}
class CheckOverGrade implements StudentChecks {
    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8;
    }
}
