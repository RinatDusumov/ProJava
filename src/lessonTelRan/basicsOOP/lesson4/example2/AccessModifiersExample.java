package lessonTelRan.basicsOOP.lesson4.example2;

public class AccessModifiersExample {
    String name;
    private String personalCode;
    public String companyName;
    protected String weaponType;

    public AccessModifiersExample(String name, String companyName, String weaponType) {
        this.companyName = companyName;
        this.name = name;
        this.weaponType = weaponType;
    }
    public String getPersonalCode() {
        return personalCode;
    }
    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }
}
