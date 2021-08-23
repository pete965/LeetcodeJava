package RealInterviewQuestions.Tecent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tencent3 {
////    n个人，面前一座独木桥，一根平衡杆子，这n个人要到另一端去；每个人都有一个t代表他用杆子到对面的时间，不过由于只有一根杆子，所以我们采用两个人合用一根杆子的方式过桥，合用时，耗时为两人中耗时更多的那个时间。问最短需要多久
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int caseNo = scanner.nextInt();
//        for (int i=0;i<caseNo;i++){
//            int output = 0;
//            int n = scanner.nextInt();
//            ArrayList<Integer> arrayList = new ArrayList<>();
//            for (int j=0;j<n;j++){
//                arrayList.add(scanner.nextInt());
//            }
//            if (arrayList.size()==1){
//                System.out.println(arrayList.get(0));
//                return;
//            }
//            arrayList.sort(Comparator.naturalOrder());
//            PriorityQueue<Integer> other = new PriorityQueue<>();
//            while (arrayList.size()!=0){
//                if (arrayList.size()==1){
//                    output+=arrayList.get(0);
//                    arrayList.remove(0);
//                }
//                int small = arrayList.get(0);
//                int big = arrayList.get(1);
//                output+=big;
//                arrayList.remove(0);
//                arrayList.remove(1);
//                other.add(small);
//                other.add(big);
//            }
//            System.out.println(output);
//        }
//
//        for (int i=n-1;i>=0;i-=2){
//            output+=arrayList.get(i);
//        }
//        System.out.println(output);
//    }
}
