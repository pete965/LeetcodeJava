package RealInterviewQuestions.Huawei;

import java.util.ArrayList;
import java.util.Scanner;
//输入n和L，n个字符，长度最长为L，问能组成多少个字符的可能；
//输入描述：每一行两个数，分别为n和l的值，最后以0 0结尾。
//输出描述：对于每组n和L，能组成的不同字符串的数量
//如：2 3
//相当于字符0和1，组成长度小于等于3的字符串，总共有：
//0,1，00,01,10,11,000,001,010,011,100,101,110,111
//共14种可能性
//思路：
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
