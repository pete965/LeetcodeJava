package HuaweiMachineExamPrepare;

import java.util.Scanner;

public class HexToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int dec = 0;
            int count = 0;
            String hex = sc.nextLine();
            for (int i = hex.length() - 1; i >= 0; i--) {
                char currentChar = hex.charAt(i);
                if (currentChar == 'x') {
                    break;
                } else {
                    if (currentChar >= '0' && currentChar <= '9') {
                        dec += (currentChar - '0') * Math.pow(16, count);
                    } else {
                        dec += (currentChar - 'A' + 10) * Math.pow(16, count);
                    }
                }
                count++;
            }
            System.out.println(dec);
        }
    }
}
