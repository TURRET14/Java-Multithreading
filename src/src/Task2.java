package src;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
    static class RandomThread extends Thread {
        CopyOnWriteArrayList<Integer> RandomList;
        public RandomThread(CopyOnWriteArrayList<Integer> List) {
            this.RandomList = List;
        }

        public void run() {
            int RandomInt = ThreadLocalRandom.current().nextInt(1, 101);
            RandomList.add(RandomInt);
        }
    }

    static public void Task2() {
        CopyOnWriteArrayList<Integer> RandomList = new CopyOnWriteArrayList<>();
        ArrayList<RandomThread> ThreadList = new ArrayList<>();
        for (int Count = 0; Count < 10; Count = Count + 1) {
            RandomThread NewThread = new RandomThread(RandomList);
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
        for (int Count = 0; Count < RandomList.size(); Count = Count + 1) {
            System.out.print(RandomList.get(Count) + " | ");
        }
        System.out.println();
    }
}
