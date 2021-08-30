package HuaweiMachineExamPrepare.HJ7;

import java.util.Scanner;

public class FourRemoveFiveInc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float input = sc.nextFloat();
        int intPart = (int)input;
        if (input - (float)intPart >=0.5){
           intPart++;
        }
        System.out.println(intPart);
    }
}
