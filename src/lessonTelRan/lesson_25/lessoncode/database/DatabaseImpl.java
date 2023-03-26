package lessonTelRan.lesson_25.lessoncode.database;

import lessonTelRan.lesson_25.lessoncode.entity.ContractorPeople;
import lessonTelRan.lesson_25.lessoncode.entity.Employer;

import java.util.HashSet;
import java.util.Set;

public class DatabaseImpl implements Database{
    Set<Employer> employers = new HashSet<>();
    Set<ContractorPeople> contractorPeoples = new HashSet<>();

    @Override
    public void add(Employer employer) {
        employers.add(employer);
    }

    @Override
    public void add(ContractorPeople contractorPeople) {
        contractorPeoples.add(contractorPeople);
    }
}
