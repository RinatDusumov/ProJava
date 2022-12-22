package lesson.basicsOOP.lesson3.interfaces;

public class RockMusician implements Musician {
    private String name;

    @Override
    public void dance() {
        System.out.println("Dancing rock");
    }

    @Override
    public void playMusic() {

    }

    @Override
    public void sing() {
        System.out.println("Singing rock");
    }

    @Override
    public void greeting() {

    }

    @Override
    public String getName() {
        return name;
    }
}
