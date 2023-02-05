package udemy.generics.igraPrimer;

public class TeamTest {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Ira", 15);

        Student student1 = new Student("Nikolai", 20);
        Student student2 = new Student("Kseniya", 18);

        Employee employee1 = new Employee("Richard", 32);
        Employee employee2 = new Employee("Charle", 47);

        Team<Schoolar> schoolarTeam = new Team("Drakony");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<>("Orly");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("Rabotyagi");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team<Schoolar> schoolarTeam2 = new Team<>("Barsy");
        Schoolar schoolar3 = new Schoolar("Sergey", 13);
        Schoolar schoolar4 = new Schoolar("Marina", 12);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

        schoolarTeam.playWith(schoolarTeam2);
    }
}
