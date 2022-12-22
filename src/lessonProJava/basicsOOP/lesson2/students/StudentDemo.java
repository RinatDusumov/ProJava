package lessonProJava.basicsOOP.lesson2.students;

public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.learn();

        System.out.println("====== JUNIOR ======");
        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
        juniorDeveloper.learn();
        juniorDeveloper.code();

        System.out.println("====== Middle ======");
        MiddleDeveloper middleDeveloper = new MiddleDeveloper();
        middleDeveloper.learn();
        middleDeveloper.code();
        middleDeveloper.debug();

        System.out.println("====== SENIOR ======");
        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
        seniorDeveloper.learn();
        seniorDeveloper.code();
        seniorDeveloper.mentoring();
        seniorDeveloper.solverProblem();
        seniorDeveloper.debug();
    }
}
