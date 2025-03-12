package src;

import java.util.concurrent.CyclicBarrier;

public class Task5 {
    static public void Task5() {
        CyclicBarrier Barrier = new CyclicBarrier(5, () -> System.out.println("Все Задачи Выполнены!"));
        for (int Count = 0; Count < 5; Count = Count + 1) {
            new Thread(new CustomRunnable(Barrier)).start();
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
