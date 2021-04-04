package RealInterviewQuestions.Meituan;

import java.util.HashSet;
import java.util.Scanner;

//第一行一个正整数n，表示切了n刀
//
//        接下来n行，每行两个整数t,x，如果t=0，那么x表示小美选择横着切的纬度；如果t=1，那么x表示小美选择竖着切的经度。
//
//        数据保证：
//
//        （1）经度的取值范围为[0,360)，纬度的取值范围为(0,360)；
//
//        （2）所有选择的经度和纬度各自均不会重复；
//
//        1≤n≤700,t∈{0,1},x∈[0,360)（此数据没有t=0,x=0的情况）
public class MeituanNew2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int plainCount = 0;
        int verticalCount = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<n;i++){
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            if (t == 0){
                plainCount++;
            }else {
                if ((!hashSet.contains(x+180))&&(!hashSet.contains(x-180))){
                    verticalCount++;
                    hashSet.add(x);
                }
            }
        }
        int plainCut = 1 + plainCount;
        int verticalCut = 1;
        for (int i=0;i<verticalCount;i++){
            verticalCut*=2;
        }
        System.out.println(plainCut*verticalCut);
    }
}
