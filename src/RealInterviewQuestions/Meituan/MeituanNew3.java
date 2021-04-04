package RealInterviewQuestions.Meituan;

import java.util.ArrayList;
import java.util.Scanner;

//小美发明了一个函数：f(x)，表示将x的所有正整数因子提取出来之后从小到大排列，再将数字拼接之后得到的数字串。例如：10的所有因子为1,2,5,10，那么将这些因子从小到大排序之后再拼接得到的数字串为12510，即f(10)=12510。
//
//        小美十分讨厌数字k，如果f(x)中含有某个子串对应的数字等于k，那么她的不高兴度就会增加1。例如：f(8)=1248，那么其所有的子串为：1,2,4,8,12,24,48,124,248,1248，只要k等于其中任意一个值，那么小美的不高兴度就会增加1。对于每一个数，其不高兴度至多增加1。
//
//        现在，有一个长度为n的正整数序列，定义其不高兴度为序列中所有数的不高兴度的总和。小美想要知道自己对于这个序列的总不高兴度为多少。
//输入描述
//        第一行两个正整数n,k；
//
//        第二行n个正整数ai，表示该序列。
//
//        1≤n≤105，1≤k，ai≤2x10^4
//
//        输出描述
//        输出一行一个正整数，表示小美的总不高兴度。
public class MeituanNew3 {
    public static void main(String[] args) {
        int output = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String k = scanner.next();
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int i=0;i<n;i++){
            int input = scanner.nextInt();
//            inputList.add(scanner.nextInt());
            if (increaseUnhappy(input,k)){
                output++;
            }
        }
//        for (Integer input:inputList){
//
//        }
        System.out.println(output);
    }

    private static boolean increaseUnhappy(int nextInt, String k) {
        String fx = calFx(nextInt);
//        System.out.println("fx is : " + fx);
        for (int i=0;i<fx.length();i++){
            if (checkUnhappy(fx,k,i,0)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkUnhappy(String fx, String k, int fxIndex,int kIndex) {
        if (kIndex==k.length()){
            return true;
        }
        if (fxIndex >= fx.length()){
            return false;
        }
        if (fx.charAt(fxIndex)==k.charAt(kIndex)){
            return checkUnhappy(fx,k,fxIndex+1,kIndex+1);
        }
        return false;
    }

    private static String calFx(int nextInt) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1;i<=nextInt;i++){
            if (nextInt%i==0){
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }
}
