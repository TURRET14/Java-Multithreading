package src;

public class Task4 {
    static class BankAccount {
        private int Balance = 0;
        public BankAccount(int Balance) {
            this.Balance = Balance;
        }
        public synchronized void ChangeBalance(int Value) {
            Balance = Balance + Value;
        }
    }
    static public void Task4() {
        BankAccount Account1 = new BankAccount(5000);
        BankAccount Account2 = new BankAccount(10000);
        BankAccount Account3 = new BankAccount(10000);
        Thread Thread1 = new Thread(() -> {
            Account1.ChangeBalance(-5000);
            Account2.ChangeBalance(5000);
        });
        Thread Thread2 = new Thread(() -> {
            Account2.ChangeBalance(-10000);
            Account3.ChangeBalance(10000);
        });
        Thread1.start();
        Thread2.start();

        try {
            Thread1.join();
            Thread2.join();
        }
        catch(InterruptedException Ex) {
            System.out.print("Thread Interrupted");
        }
        System.out.println("Счет 1: " + Account1.Balance);
        System.out.println("Счет 2: " + Account2.Balance);
        System.out.println("Счет 3: " + Account3.Balance);
    }
}
