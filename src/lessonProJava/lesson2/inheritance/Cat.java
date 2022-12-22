package lessonProJava.lesson2.inheritance;

public class Cat extends Dog {
    @Override
    public void voice() {
        super.voice();
        System.out.println("Cat voice");
    }
}
