package lessonProJava.lesson1;

public class MyPhone {
    private int number;
    private Phone phone;

    public MyPhone(int number, Phone phone) {
        this.number = number;
        this.phone = phone;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public void ring(int callNumber) {
        System.out.println("For number " + this.number + " is calling " +
                callNumber);
    }
    //для переопределение состояния объекта не изменяя оригинал
/*  создать новый метод
*   public void changeName (String newColor) {
*   this.phone.setColor(newColor);
    } */
    @Override
    public String toString() {
        return "MyPhone{" +
                "number=" + number +
                ", phone=" + phone +
                '}';
    }
}
