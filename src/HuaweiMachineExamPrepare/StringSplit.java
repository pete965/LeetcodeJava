package HuaweiMachineExamPrepare;

import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String lineInput = sc.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < lineInput.length(); i++) {
                stringBuilder.append(lineInput.charAt(i));
                if ((i + 1) % 8 == 0) {
                    System.out.println(stringBuilder);
                    stringBuilder = new StringBuilder();
                }
            }
            if (stringBuilder.length()!=0){
                while (stringBuilder.length()<8){
                    stringBuilder.append(0);
                }
                System.out.println(stringBuilder);
            }
        }
    }
}
