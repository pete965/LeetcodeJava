package HuaweiMachineExamPrepare.HJ12;

import java.util.Locale;
import java.util.Scanner;

public class RevertToLowCaseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(input.toLowerCase(Locale.ROOT));
        System.out.println(stringBuilder.reverse());
    }
}
