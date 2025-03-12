package src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    static public void Task3() {
        ExecutorService Service = Executors.newFixedThreadPool(4);
        for (int Count = 0; Count < 20; Count = Count + 1) {
            int TaskCount = Count;
            Service.submit(() -> System.out.println("Task Number: " + TaskCount));
        }
        Service.shutdown();
        Service.close();
    }
}
