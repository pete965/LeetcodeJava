package RealInterviewQuestions.Tecent;

import java.util.HashSet;
import java.util.Scanner;
//消消乐，输入一个纯数字字符串，相加为10且相邻的数字消掉，类似祖玛，求最后长度
public class Tencent2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int output = n;
        String s = scanner.next();
        HashSet<Integer> hashSet = new HashSet<>();
        int i=0;
        while (i<n-1){
            if (hashSet.contains(i)){
                i++;
                continue;
            }
            int j=i+1;
            while (hashSet.contains(j)){
                j++;
            }
            if (j>=n){
                i++;
                continue;
            }
            int before = s.charAt(i) - '0';
            int after = s.charAt(j) - '0';
            if (before+after==10){
//                    System.out.println(before+" "+after);
                output-=2;
                hashSet.add(i);
                hashSet.add(j);
                i--;
                continue;
            }
            i++;
        }
        System.out.println(output);
    }
}
