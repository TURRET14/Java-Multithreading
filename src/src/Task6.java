package src;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Task6 {
    public static void Task6() {
        Semaphore Sem = new Semaphore(2);
        CommonResource Res = new CommonResource();
        for (int Count = 0; Count < 5; Count = Count + 1) {
            new Thread(new CustomRunnable(Sem, Res)).start();
        }
    }
    static class CommonResource {
        public ArrayList<String> Arr = new ArrayList<>();
    }
    static class CustomRunnable implements Runnable {
        private Semaphore Sem;
        private CommonResource Res;
        public CustomRunnable(Semaphore Sem, CommonResource Res) {
            this.Sem = Sem;
            this.Res = Res;
        }
        public void run() {
            try {
                Sem.acquire(1);
                Res.Arr.add("Text");
                System.out.println("Added Text.");
                Sem.release(1);
            }
            catch (InterruptedException Ex) {
                System.out.println("Exception Occurred.");
            }
        }
    }
}
