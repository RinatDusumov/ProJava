package lessonProJava.lesson2.students;

public class MiddleDeveloper extends JuniorDeveloper {
    void debug() {
        System.out.println("Debuging");
    }

    @Override
    void code() {
        super.code();
        System.out.println("Coding like a middle developer");
    }
}
