package src;

import java.util.concurrent.ArrayBlockingQueue;

public class Task8 {
    static public void Task8() {
        ArrayBlockingQueue<String> Items = new ArrayBlockingQueue<>(10);
        Thread ThreadPut = new Thread(() -> {
            try {
                for (int Count = 0; Count < 10; Count = Count + 1) {
                    Items.put("Item");
                }
            }
            catch (Exception Ex) {
                System.out.println("Exception Occurred.");
            }
        });

        Thread ThreadGet = new Thread(() -> {
            try {
                for (int Count = 0; Count < 10; Count = Count + 1) {
                    System.out.print(Items.take() + " | ");
                }
                System.out.println();
            }
            catch (Exception Ex) {
                System.out.println("Exception Occurred.");
            }
        });
        ThreadPut.start();
        ThreadGet.start();
    }
}
