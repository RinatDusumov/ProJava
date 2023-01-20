package udemy.linkedList;
/* Элементы LinkedList - это звенья одной цепочки. Эти элементы хранят
    определённые данные, а также ссылки на предыдущий и следующий элементы
 */
// базовые методы те же что в arraylist, т.к. оба иплементируют интерфейс list

/* использовать массив, если известно кол-во элементов и если добавлений, удалений не будет
                arraylist(в основе массив), если кол-во элементов не известно или будут добавления, удаления. лучше работает при поиске случайного элемента
                linkedlist(в основе цепочка), когда много добавлений, удалений. лучше работает когда нужно добавить или удалить элемент в середине списка */

/* существует dovbly linkedlist, когда звено хранит ссылки на предыдущий и следующий элементы
              singly linkedlist, когла звено хранит ссылку только следующего элемента */

/* Как правило, LinkedList следует использовать когда:
    1) Невелико кол-во операций получения элементов
    2) Велико кол-во операций добавления и удаления элементов.
       Особенно если речь идёт о элементах в начале коллекции.
 */
import java.util.LinkedList;

public class LinkedListEx1 {
    public static void main(String[] args) {
        Student2 st1 = new Student2("Ivan", 3);
        Student2 st2 = new Student2("Nikolay", 2);
        Student2 st3 = new Student2("Elena", 1);

        LinkedList<Student2> student2LinkedList = new LinkedList<>();
        student2LinkedList.add(st1);
        student2LinkedList.add(st2);
        student2LinkedList.add(st3);

        System.out.println("LinkedList = " + student2LinkedList);
        System.out.println(student2LinkedList.get(2));

        Student2 st4 = new Student2("Mariya", 3);
        Student2 st5 = new Student2("Igor", 4);
        student2LinkedList.add(st4);
        System.out.println("LinkedList = " + student2LinkedList);
        student2LinkedList.add(1, st5);

        student2LinkedList.remove(3);
        System.out.println("LinkedList = " + student2LinkedList);
    }
}
class Student2 {
    String name;
    int course;

    public Student2 (String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
