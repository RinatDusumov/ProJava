package lesson.basicsOOP.lesson4.example1;

import java.util.Arrays;

public class UserRepository {
    private UserEntity[] dataBase = new UserEntity[0];
    public void add(UserEntity str) {
        // dataBase.length == 0 create new DB min size 1
        UserEntity[] newDataBase = new UserEntity[dataBase.length + 1];
        for (int i = 0; i < dataBase.length; i++) {
            newDataBase[i] = dataBase[i];
        }
        newDataBase[dataBase.length] = str;
        dataBase = newDataBase;
    }
    public void printInformation() {
        for (int i = 0; i < dataBase.length; i++) {
            System.out.println(dataBase[i]);
        }
        //System.out.println(Arrays.toString(dataBase));
    }
    public void changeName(int userID, String name) {
        for (int i = 0; i < dataBase.length; i++) {
            if (dataBase[i].getUserID() == userID) {
                UserEntity userEntity = dataBase[i];
                userEntity.setUserName(name);
                return;
            }
        }
    }
    public UserEntity[] getDataBase() {
        return Arrays.copyOf(dataBase, dataBase.length);
    }
}
