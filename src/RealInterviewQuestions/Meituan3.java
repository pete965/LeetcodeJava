package RealInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//轮流出局
//        时间限制：C/C++语言 2000MS；其他语言 4000MS
//        内存限制：C/C++语言 65536KB；其他语言 589824KB
//        题目描述：
//        现在有n名选手进行轮流报数，选手按顺序编号为1~n，另外我们会给出一个序列A，游戏会进行n轮，每轮会出局一名选手，第i轮淘汰的选手最后的排名是n-i+1,即第一轮出局的是倒数第一。出局的选手不会参与下一轮报数。
//
//        每轮游戏都是从第一个选手开始报数，即如果1号选手仍在，则从1号选手开始，否则从2号选手开始，以此类推，但是注意，每轮报数是从0开始的，第i轮时，第一个报到A[i]的选手会出局，且当前轮游戏结束。A[i]有可能大于当前的剩余人数，则最后一个人报完以后，会由第一个人接着报，直到报出A[i]。
//
//        输入
//        输入第一行包含一个正整数n，表示有n名选手。(1<=n<=100000)
//
//        输入第二行包含n个正整数，表示序列A。(0<=A[i]<=10^9)
//
//        输出
//        输出包含n行，每行一个正整数，第i行的正整数表示i号选手的排名是多少。即输出是一个1~n的排列。
//
//
//        样例输入
//        4
//        1 2 1 2
//        样例输出
//        1
//        4
//        2
//        3
//
//        提示
//        样例解释，
//        第一轮中，1-4号选手报数分别是0，1，+，+（+代表未报数），因为A[1]=1，所以2号选手出局，排名为4。
//        第二轮中，1-4号选手报数为0，-，1，2（-代表一出局），因为A[2]=2,所以4号选手出局，排名为3。
//        第三轮中，1-4号选手报数为0，-，1，-，因为A[3]=1，所以3号选手出局，排名为2。
//        第四轮只有1号选手了，所以他会报所有的数字，最后出局。
public class Meituan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
            arrayList.add(i+1);
        }
        HashMap<Integer,Integer> rank = new HashMap<>();
        for (int i=0;i<n;i++){
            int length = arrayList.size();
            nums[i]%=length;
            rank.put(arrayList.get(nums[i]),n-i);
            arrayList.remove(nums[i]);
        }
        for (int i=1;i<=n;i++){
            System.out.println(rank.get(i));
        }
    }
}
