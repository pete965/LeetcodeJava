package HuaweiMachineExamPrepare.Medium.HJ9;

import java.util.HashSet;
import java.util.Scanner;

public class GetNonRepeatableInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        HashSet<Character> hashSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=input.length()-1;i>=0;i--){
            Character current = input.charAt(i);
            if (!hashSet.contains(current)){
                stringBuilder.append(current);
                hashSet.add(current);
            }
        }
        System.out.println(stringBuilder);
    }
}
