package lessonTelRan.lesson_25.lessoncode.database;


import lessonTelRan.lesson_25.lessoncode.entity.ContractorPeople;
import lessonTelRan.lesson_25.lessoncode.entity.Employer;
import lessonTelRan.lesson_25.lessoncode.entity.Person;

public interface Database {
    void add(Employer employer);
    void add(ContractorPeople contractorPeople);
}
