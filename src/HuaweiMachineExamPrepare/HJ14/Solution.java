package HuaweiMachineExamPrepare.HJ14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        int count = scanner.nextInt();
        for (int i=0;i<count;i++){
            arrayList.add(scanner.next());
        }
        Comparator<String> comparator = (o1, o2) -> {
            int size = Math.min(o1.length(),o2.length());
            for (int i=0;i<size;i++){
                if (o1.charAt(i)!=o2.charAt(i)){
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
            return o1.length()-o2.length();
        };
        arrayList.sort(comparator);
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
