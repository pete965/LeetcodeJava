package HuaweiMachineExamPrepare.HJ22;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            int output = 0;
            while (input > 2 ){
                output += input / 3;
                input = input / 3 + input % 3;
            }
            if (input == 2){
                output++;
            }
            System.out.println(output);
        }
    }
}
