package RealInterviewQuestions.Netease;

/*
题目：神奇的数字
如果一个N位的数字满足以下条件，我们认为这是一个神奇的数字：
1.N位的十进制数字，每一位是0-9,特别的，我们允许前序0存在，即1234和0012都是合法的四位数
2.将每一位的数字加起来和刚好等于S
3.在这个N位的数字中，任意连续三位数字构成的三位数都能被X整除
输入描述：
三个整数：N(3<=N<=50)，S(0<=S<=N*9)，X(1<=X<=999)
输出描述：
满足以上条件的数字总数 mod 1000009
因为这个总数可能很大，所以模1000009即可
示例输入：
4 3 3
示例输出：
6
说明：共六个数
3000 0300 0030 0003 0120 0210
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ArrayList<Integer> candidate = new ArrayList<>();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        long count = 0L;
        LinkedList<ArrayList<Integer>> lists = new LinkedList<>();
        ArrayList<Integer> single = new ArrayList<>();
        allPossible(lists,single,n,s);
        System.out.println(lists.toString());
        for (ArrayList<Integer> arrayList:lists){
            if (checkX(arrayList,x)){
                count++;
                System.out.println(arrayList.toString());
            }
        }
        System.out.println(count%1000009);
    }

    private static boolean checkX(ArrayList<Integer> list,int x) {
        int length = list.size();
        int num = 0;
        for (int i=0;i<length;i++){
            num+=list.get(i)*Math.pow(10,length-1-i);
        }
        for (int i=0;i<length-2;i++){
            if ((num%1000)%x!=0){
                return false;
            }
            num/=10;
        }
        return true;
    }

    private static void allPossible(LinkedList<ArrayList<Integer>> output, ArrayList<Integer> single, int n, int k) {
        if (n == 1) {
            single.add(k);
            output.add(new ArrayList<Integer>(single));
            System.out.println(single.toString());
            single.remove(single.size()-1);
        } else {
            for (int i = 0;i <= k; i++){
                single.add(i);
                allPossible(output, single,n-1,k-i);
                single.remove(single.size()-1);
            }
        }
    }
}
