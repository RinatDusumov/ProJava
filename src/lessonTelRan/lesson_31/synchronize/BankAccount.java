package lessonTelRan.lesson_31.synchronize;

class BankAccount {
    private int balance;
    public synchronized void increaseBalance() {
        balance = balance + 1_000;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
