package lessonTelRan.lesson_21.junitExample;

public class UsersApp {
    public static void main(String[] args) {
        UserUtils uu = new UserUtils();
        User user1 = new User(1,"Petr", 25, Sex.MAN);
        User user2 = new User(2,"Ivan", 26, Sex.MAN);
        User user3 = new User(3,"Ruslan", 27, Sex.MAN);
        User user4 = new User(4,"Olga", 22, Sex.WOMAN);
        User user5 = new User(5,"Inna", 21, Sex.WOMAN);

        uu.allUsers.put(1, user1);
        uu.allUsers.put(2, user2);
        uu.allUsers.put(3, user3);
        uu.allUsers.put(4, user4);
        uu.allUsers.put(5, user5);

        System.out.println(uu.getAllUsers());

        System.out.println(uu.getHowManyUsers());
        System.out.println(uu.getHowManyUsers(Sex.MAN));
        System.out.println(uu.getHowManyUsers(Sex.WOMAN));
    }
}
