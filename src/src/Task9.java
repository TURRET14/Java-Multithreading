package src;

import java.util.ArrayList;
import java.util.List;

public class Task9 {
    static public void Task9() {
        ArrayList<Long> Arr = new ArrayList<>(List.of(500L, 100L, 5000L, 10L, 5L));
        QuickSort(Arr);
        for (long Element : Arr) {
            System.out.print(Element + " | ");
        }
    }
    static public void QuickSort(ArrayList<Long> Arr) {
        if (Arr.size() > 1) {
            int MiddleID = Arr.size() / 2;
            ArrayList<Long> Left = new ArrayList<>();
            ArrayList<Long> Right = new ArrayList<>();
            for (int Count = 0; Count < Arr.size(); Count = Count + 1) {
                if (Count != MiddleID) {
                    if (Arr.get(Count) < Arr.get(MiddleID)) {
                        Left.add(Arr.get(Count));
                    }
                    else {
                        Right.add(Arr.get(Count));
                    }
                }
            }
            long MiddleElement = Arr.get(MiddleID);
            Thread LeftThread = new Thread(() -> QuickSort(Left));
            Thread RightThread = new Thread(() -> QuickSort(Right));
            LeftThread.start();
            RightThread.start();
            try {
                LeftThread.join();
                RightThread.join();
            }
            catch (Exception Ex) {
                System.out.println("Exception Occurred.");
            }
            Arr.clear();
            Arr.addAll(Left);
            Arr.add(MiddleElement);
            Arr.addAll(Right);
        }
    }
}
