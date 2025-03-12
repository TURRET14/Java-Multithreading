package src;

import java.util.ArrayList;

public class Task1 {
    static class Counter {
        int Counter = 0;
    }
    static class CounterThread extends Thread {
        Counter CounterObject;
        public CounterThread(Counter CounterObject) {
            this.CounterObject = CounterObject;
        }

        public void run() {
            for (int Count = 0; Count < 1000; Count = Count + 1) {
                synchronized (CounterObject) {
                    CounterObject.Counter = CounterObject.Counter + 1;
                }
            }
        }
    }

    static public void Task1() {
        Counter MainCounter = new Counter();
        ArrayList<CounterThread> ThreadList = new ArrayList<>();
        for (int ThreadCount = 0; ThreadCount < 5; ThreadCount = ThreadCount + 1) {
            CounterThread NewThread = new CounterThread(MainCounter);
            ThreadList.add(NewThread);
            NewThread.start();
        }
        for (int Count = 0; Count < ThreadList.size(); Count = Count + 1) {
            try {
                ThreadList.get(Count).join();
            }
            catch(InterruptedException Ex) {
                System.out.print("Thread Interrupted");
            }
        }
        System.out.println(MainCounter.Counter);
    }
}
