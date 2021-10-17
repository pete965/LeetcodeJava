package HuaweiMachineExamPrepare.Easy.HJ15;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;
        while (input >= 1) {
            if (input % 2 == 1){
                count++;
            }
            input/=2;
        }
        System.out.println(count);
    }
}
