package HuaweiMachineExamPrepare.Hard.HJ17;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] instructions = input.split(";");
        int x = 0;
        int y = 0;
        for (String ins : instructions) {
            if (!checkValid(ins)) {
                System.out.println("Invalid Operation");
                continue;
            } else {
                int moveNum;
                if (ins.length() == 2) {
                    moveNum = ins.charAt(1) - '0';
                } else {
                    moveNum = (ins.charAt(1) - '0') * 10 + ins.charAt(2) - '0';
                }
                char direction = ins.charAt(0);
                if (direction == 'W') {
                    y+=moveNum;
                }else if (direction == 'S') {
                    y-=moveNum;
                }else if (direction == 'A') {
                    x-=moveNum;
                }else {
                    x+=moveNum;
                }
            }
        }
        System.out.println(x+","+y);
    }

    private static boolean checkValid(String ins) {
        System.out.println(ins);
        int length = ins.length();
        if (length < 2 || length > 3) {
            return false;
        }
        if (ins.charAt(0) == 'W' || ins.charAt(0) == 'S' || ins.charAt(0) == 'A' || ins.charAt(0) == 'D') {
            if (length == 2) {
                if (ins.charAt(1) <= '9' && ins.charAt(1) >= '0') {
                    return true;
                } else {
                    return false;
                }
            } else {
                if ((ins.charAt(2) <= '9' && ins.charAt(2) >= '0') && (ins.charAt(1) <= '9' && ins.charAt(1) >= '1')) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
