package lessonTelRan.lesson_21.junitExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserUtils {
    public Map<Integer,User> allUsers = new HashMap<>();
    public List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }
    public List<User> getAllUsers(Sex sex) {
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()) {
            if(user.getSex() == sex) {
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }
    public int getHowManyUsers() {
        return allUsers.size();
    }
    public int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }
    public int getAllAgeUser() {
        int count = 0;
        for (User user : allUsers.values()) {
            count = count + user.getAge();
        }
        return count;
    }
    public int getAllAgeUser(Sex sex) {
        int count = 0;
        for (User user : getAllUsers(sex)) {
            count = count + user.getAge();
        }
        return count;
    }
}