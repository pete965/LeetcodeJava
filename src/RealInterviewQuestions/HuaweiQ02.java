package RealInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//对于一个二进制数，我们可以把其中的“00”变为“10”；可以把其中的“10”变为“01”，问输入一个二进制数，最大能变成多少
//输入描述，第一行为case的总数；对于下面的每两行中，第一行为二进制数的位数，第二行为对应二进制数
//输入：
//        2
//        2
//        10
//        4
//        0001
//输出：
//        10
//        1101
//输入输出解释：
//第一行2说明有两组数字
//第一组数字：长度为2的二进制数“10”，可以通过上述变换得到的最大二进制数字为10
//第二组数字：长度为4的二进制数“0001”，可以通过上述变换得到的最大二进制数字为1101
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
