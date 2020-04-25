package RealInterviewQuestions.Huawei;

import java.util.Scanner;
//数独
//输入：
//        {5,0,0,6,0,2,0,0,0}
//        {0,0,8,0,7,0,2,0,0}
//        {7,0,0,8,1,0,5,4,6}
//        {2,0,1,3,0,0,9,8,5}
//        {3,4,0,0,8,0,0,0,0}
//        {0,0,9,0,0,7,0,1,4}
//        {1,5,6,0,2,0,0,0,3}
//        {4,0,2,0,9,6,0,0,7}
//        {9,0,0,0,0,3,0,0,1}
//其中0代表空位
public class HuaweiQ01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] nums = new int[9][9];
        for (int i=0;i<9;i++){
            String str = sc.next();
            for (int j=1;j<18;j+=2){
                nums[i][(j+1)/2-1] = Integer.valueOf(str.charAt(j)) - 48;
            }
        }
    }
}
