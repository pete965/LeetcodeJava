package HuaweiMachineExamPrepare.Medium.HJ34;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 图片整理
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str= scanner.nextLine();
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            for(char c :chars ){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
