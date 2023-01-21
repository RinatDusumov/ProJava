package lessonTelRan.basicsOOP.lesson4.example2;

public class HeroJB extends AccessModifiersExample {
    private String superHeroName;
    public HeroJB (String name, String companyName, String weaponType, String superHeroName) {
        super(name, companyName, weaponType);
        this.superHeroName = superHeroName;
    }
}
