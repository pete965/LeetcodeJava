package HuaweiMachineExamPrepare.Hard.HJ41;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 不管数量，就当是有相同重量的一堆砝码，一个个加进去；每一个加进去的时候，都要将其和集合中已经可能产生的重量各自相加产生新的重量可能性，用set去重
        // 每加入一个砝码，假设集合中原有3个数，即原有3种重量可能，那么我们相当于加入了6中可能进去，三种可能每种对应（加新砝码重量或者加0（不加新砝码））
    }
}
