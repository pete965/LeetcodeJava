package RealInterviewQuestions;

import java.util.ArrayList;
import java.util.Scanner;
//输入n和L，n个字符，长度最长为L，问能组成多少个字符的可能；
//即pow（n,1）+...+pow(n,L)
//防止越界即可，最后通过40%
//输入：
//        2 3
//        100 15
//        0 0
//输出：
//        14
//        979451521

public class HuaweiQ03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int divide = 1000000007;
        int output = 0;
        int n=sc.nextInt();
        int l=sc.nextInt();
        while(!(n==0&&l==0)){
            for (int i = 1;i<=l;i++){
                int add = n%divide;
                int everytime = add;
                for (int j= 0;j<i-1;j++){
                    add%=divide;
                    for (int k=0;k<n-1;k++){
                        if (Integer.MAX_VALUE-everytime<add){
                            add%=divide;
                        }
                        add+=everytime;
                    }
                    everytime=add;
                    everytime%=divide;
                }
                add%=divide;
                if (Integer.MAX_VALUE-add<output){
                    add%=divide;
                    output%=divide;
                }
                output+=add;
                output%=divide;
            }
            arrayList.add(output);
            output = 0;
            n=sc.nextInt();
            l=sc.nextInt();

        }
        for (Integer integer:arrayList){
            System.out.println(integer);
        }
    }
}
