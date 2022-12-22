package lessonProJava.basicsOOP.lesson3.interfaces;

public class PopMusician implements Musician {
    @Override
    public void dance() {
        System.out.println("pop dancing");
    }

    @Override
    public void sing() {
        System.out.println("pop singing");
    }

    @Override
    public void greeting() {
        System.out.println("pop greeting");
    }

    @Override
    public String getName() {
        return "WOW";
    }

    @Override
    public void playMusic() {

    }
}
