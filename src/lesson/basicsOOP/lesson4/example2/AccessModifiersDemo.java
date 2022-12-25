package lesson.basicsOOP.lesson4.example2;

public class AccessModifiersDemo {
    public static void main(String[] args) {
        AccessModifiersExample accessModifiersExample = new AccessModifiersExample(
                "James Bond", "007", "Universal Exports");
        accessModifiersExample.weaponType = "Beretta";
    }
}
