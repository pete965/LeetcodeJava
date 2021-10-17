package HuaweiMachineExamPrepare.Easy.HJ11;

import java.util.Scanner;

public class RevertTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(input);
        System.out.println(stringBuilder.reverse());
    }
}
