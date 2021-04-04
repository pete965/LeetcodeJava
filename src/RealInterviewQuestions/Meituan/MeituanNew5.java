package RealInterviewQuestions.Meituan;

import java.util.ArrayList;
import java.util.Scanner;

//小团和小美分别从家里拿了A颗糖果和B颗糖果。每一颗糖果都有一个甜度，不同糖果的甜度可能相同，并且有些糖果味道可能很差，其甜度为零甚至是负值。小美和小团一起把这些糖果分给幼儿园的小朋友，但是有个规则：对于两个人手上的糖果只能按顺序一个一个地拿，即将两个人手上的糖果每个人分别标记为1，2，3…，在拿走某一个人的第i颗糖果之前的所有i-1颗糖果都必须全部拿走。
//
//        小朋友们可以任意选择拿的数目，甚至可以一颗也不拿，他们能够获得的甜度总和的最大值为多少？
//输入描述
//        第一行A，B两个整数；
//
//        第二行A个整数a1,a2,a3,...,aA，表示小团手上第i颗糖果的甜度；
//
//        第三行B个整数b1,b2,b3,...,bB，表示小美手上第i颗糖果的甜度。
//
//        1<=A+B<=200000, -100<=ai,bi<=100。
//
//        输出描述
//        输出仅包含一个非负整数，表示能够获得的甜度之和的最大值，例如当糖果都为负数的时候，答案为0。
//        样例输入
//        3 4
//        1 -1 0
//        2 2 -5 3
//        样例输出
//        5
//
//        提示
//        拿走小团的第一颗糖果和小美的前两颗糖果，甜度之和最大。如果要拿走小美的第四颗糖果，那么小美手上前面三颗都要全部拿走，拿走小团的第一颗糖果，此时甜度之和为3，并不是最优解。
public class MeituanNew5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i=0;i<a;i++){
            aList.add(scanner.nextInt());
        }
        for (int i=0;i<b;i++){
            bList.add(scanner.nextInt());
        }
        int[] matrixA = new int[aList.size()];
        matrixA[0] = aList.get(0);
        int aMax = Math.max(0,matrixA[0]);
        int[] matrixB = new int[bList.size()];
        matrixB[0] = bList.get(0);
        int bMax = Math.max(0,matrixB[0]);
        for (int i=1;i<aList.size();i++){
            matrixA[i] = matrixA[i-1] + aList.get(i);
            aMax = Math.max(aMax,matrixA[i]);
        }
        for (int i=1;i<bList.size();i++){
            matrixB[i] = matrixB[i-1] + bList.get(i);
            bMax = Math.max(bMax,matrixB[i]);
        }
        System.out.println(aMax+bMax);
    }
}
