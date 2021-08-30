package HuaweiMachineExamPrepare.HJ8;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeTableItems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < count; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (!hashMap.containsKey(key)){
                hashMap.put(key,value);
                priorityQueue.offer(key);
            }else {
                hashMap.put(key,hashMap.get(key)+value);
            }
        }
        while (priorityQueue.size()!=0){
            int key = priorityQueue.poll();
            int value = hashMap.get(key);
            System.out.println(key+" "+value);
        }
    }
}
