package lessonTelRan.lesson_25.lessoncode.entity;

public class ContractorPeople extends Person{
    String contractNumber;
    String info;

    public ContractorPeople(int id, String name, SEX sex, int age, String contractNumber, String info) {
        super(id, name, sex, age);
        this.contractNumber = contractNumber;
        this.info = info;
    }
}
