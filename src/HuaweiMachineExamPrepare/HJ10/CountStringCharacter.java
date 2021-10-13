package HuaweiMachineExamPrepare.HJ10;

import java.util.HashSet;
import java.util.Scanner;

public class CountStringCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int count = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<input.length();i++){
            int current = input.charAt(i);
            if (current<128){
                if (!hashSet.contains(current)){
                    count++;
                    hashSet.add(current);
                }
            }
        }
        System.out.println(count);
    }
}
