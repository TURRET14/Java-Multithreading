package src;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Task7 {
    public static void Task7() {
        ArrayList<CompletableFuture<Integer>> ThreadList = new ArrayList<>();
        int FactorialNumber = 0;
        for (int Count = 0; Count < 10; Count = Count + 1) {
            FactorialNumber = FactorialNumber + 1;
            int Number = FactorialNumber;
            CompletableFuture<Integer> NewThread = CompletableFuture.supplyAsync(() -> {
                int Result = 1;
                for (int FactCount = 1; FactCount <= Number; FactCount = FactCount + 1) {
                    Result = Result * FactCount;
                }
                return Result;
            });
            ThreadList.add(NewThread);
        }
        FactorialNumber = 0;
        for (int Count = 0; Count < ThreadList.size(); Count = Count + 1) {
            FactorialNumber = FactorialNumber + 1;
            try {
                System.out.println("Факториал " + FactorialNumber + ": " + ThreadList.get(Count).get());
            }
            catch (Exception Ex) {
                System.out.println("Exception Occurred.");
            }
        }
    }
}
