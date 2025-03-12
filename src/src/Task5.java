package src;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Task5 {
    static public void Task5() {
        CyclicBarrier Barrier = new CyclicBarrier(5, () -> System.out.println("Все Задачи Выполнены!"));
        ArrayList<Thread> ThreadList = new ArrayList<>();
        for (int Count = 0; Count < 5; Count = Count + 1) {
            Thread NewThread = new Thread(new CustomRunnable(Barrier));
            ThreadList.add(NewThread);
            NewThread.start();
        }
        for (Thread Object : ThreadList) {
            try {
                Object.join();
            }
            catch (Exception Ex) {
                System.out.println("Exception Occurred.");
            }
        }
    }
    static class CustomRunnable implements Runnable {
        private CyclicBarrier Barrier;
        public CustomRunnable(CyclicBarrier Barrier) {
            this.Barrier = Barrier;
        }
        public void run() {
            System.out.println("Поток Ожидает.");
            try {
                Barrier.await();
            }
            catch(Exception Ex) {
                System.out.println("Exception Occurred.");
            }
        }
    }
}
