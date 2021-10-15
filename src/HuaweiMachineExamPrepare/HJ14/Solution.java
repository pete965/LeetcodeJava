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
        arrayList.sort(Comparator.naturalOrder());
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
