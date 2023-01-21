package lessonTelRan.basicsOOP.lesson4.example1;

public class UserRepositoryDemo {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        repository.add(new UserEntity(1, "Ruslan", "ruslan", "11"));
        repository.add(new UserEntity(2, "Ruslan", "ruslan", "11"));
        repository.add(new UserEntity(3, "Ruslan", "ruslan", "11"));
        repository.add(new UserEntity(4, "Ruslan", "ruslan", "11"));
        repository.add(new UserEntity(5, "Ruslan", "ruslan", "11"));
        repository.printInformation();
        repository.changeName(2, "Petr");
        System.out.println("=====");
        repository.printInformation();
        UserEntity[] database = repository.getDataBase();
        for (int i = 0; i < database.length; i++) {
            database[i] = null;
        }
        repository.printInformation();
    }
}
