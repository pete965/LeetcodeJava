package HuaweiMachineExamPrepare;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MingRandomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            HashSet<Integer> hashSet = new HashSet<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int i = 0; i < num; i++) {
                int thisNum = sc.nextInt();
                if (!hashSet.contains(thisNum)) {
                    hashSet.add(thisNum);
                    priorityQueue.add(thisNum);
                }
            }
            while (!priorityQueue.isEmpty()) {
                System.out.println(priorityQueue.poll());
            }
        }
    }
}
