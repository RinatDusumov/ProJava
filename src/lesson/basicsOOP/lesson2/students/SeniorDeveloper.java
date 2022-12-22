package lesson.basicsOOP.lesson2.students;

public class SeniorDeveloper extends MiddleDeveloper {
    void mentoring() {
        System.out.println("Mentoring");
    }

    void solverProblem() {
        System.out.println("Problem solver");
    }
    @Override
    void code() {
        System.out.println("Simple coding");
    }
    @Override
    void learn() {
        System.out.println("Fast learning");
    }
}
