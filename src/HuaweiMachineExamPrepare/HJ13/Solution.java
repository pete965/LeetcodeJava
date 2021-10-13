package HuaweiMachineExamPrepare.HJ13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        while (scanner.hasNext()) {
            arrayList.add(scanner.next());
        }
        Collections.reverse(arrayList);
        int index = 0;
        for (String s : arrayList) {
            System.out.print(s);
            if (index!=arrayList.size()-1){
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }
}
