package Leetcode.No_1046_Last_Stone_Weight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{1,5,4,7,9}));
        System.out.println(solution.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(solution.lastStoneWeight(new int[]{1,5}));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1<o2){
                    return 1;
                }else if (o1>o2){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        for (int i:stones){
            priorityQueue.add(i);
        }
        while (priorityQueue.size()>=2){
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if (a != b){
                priorityQueue.add(a-b);
            }
        }
        if (priorityQueue.size()==1){
            return priorityQueue.poll();
        }else {
            return 0;
        }
    }
}
