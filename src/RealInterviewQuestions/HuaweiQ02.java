package RealInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//二进制中，00可以变为10；10可以变为01，问输入一个二进制数，最大能变成多少
//输入：
//        2
//        2
//        10
//        4
//        0001
//输出：
//        10
//        1101
public class HuaweiQ02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i=0;i<cases;i++){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int length = sc.nextInt();
            String str = sc.next();
            for (int j=0;j<length;j++){
                if (Integer.valueOf(str.charAt(j)) == 49){
                    arrayList.add(1);
                }else {
                    arrayList.add(0);
                }
            }
            for (int j=0;j<length;j++){
                if (arrayList.get(j)==0){
                    if (j!=length-1&&arrayList.get(j+1)==0){
                        arrayList.set(j,1);
                    }
                }
            }
            arrayLists.add(arrayList);
        }
        for (ArrayList<Integer> arrayList:arrayLists){
            for (Integer integer:arrayList){
                System.out.print(integer);
            }
            System.out.print("\n");
        }
    }
}
