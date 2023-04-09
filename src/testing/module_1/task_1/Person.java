package testing.module_1.task_1;

class Person {
    public static void main(String[] args) {
        Developer dev = new Developer();
        QaSpecialist qa = new QaSpecialist();
        Manager man = new Manager();
        dev.work();
        qa.work();
        man.work();
    }
}
