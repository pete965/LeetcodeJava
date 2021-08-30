package HuaweiMachineExamPrepare.HJ6;


import java.util.PriorityQueue;
import java.util.Scanner;

public class SplitToPrimeNumbers {
    public static PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        splitPrime(num);
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.print("\n");
    }

    private static void splitPrime(long num) {
        /*
        对于一个整数x,如果[2,sqrt(x)]范围内都没有可以被x整除的数，那么x就是质数；
        因为如果x不是平方数，那么如果能分解成乘积，一定是一个大于sqrt(x)乘以一个小于sqrt(x)的数，所以后续的不用再试。
         */
        for (long i = 2; i < Math.sqrt((double) num); i++) {
            if (num % i == 0) {
                splitPrime(i);
                splitPrime(num / i);
                return;
            }
        }
        priorityQueue.offer(num);
    }

}
