package lesson.basicsOOP.lesson4.example1;
/*
Создать класс UserEntity с учетом, что вы уже знаете, что такое инкапсюляция.
У класса UserEntity должны быть поля:
  - id
  - имя
  - фамилия
  - персональный код
 */
public class UserEntity {
    private int userID;
    private String userName;
    private String userSurname;
    private String userPersonalCode;

    public UserEntity(int userID, String userName, String userSurname, String userPersonalCode) {
        this.userID = userID;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPersonalCode = userPersonalCode;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserSurname() {
        return userSurname;
    }
    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
    public String getUserPersonalCode() {
        return userPersonalCode;
    }
    public void setUserPersonalCode(String userPersonalCode) {
        this.userPersonalCode = userPersonalCode;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userPersonalCode='" + userPersonalCode + '\'' +
                '}';
    }
}
