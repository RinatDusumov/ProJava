package lessonTelRan.lesson_31.synchronize;

import java.util.HashSet;
import java.util.Set;

class BankAccountDemo {
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new HashSet<>();
        BankAccount bankAccount = new BankAccount();
        for (int i = 0; i < 1_000; i++) {
            bankAccount.setBalance(0);

            TestThread thread1 = new TestThread(bankAccount);
            TestThread thread2 = new TestThread(bankAccount);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            set.add(bankAccount.getBalance());
        }
        System.out.println(set);
    }
}
