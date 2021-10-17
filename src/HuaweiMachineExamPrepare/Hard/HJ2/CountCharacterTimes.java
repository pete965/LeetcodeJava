package HuaweiMachineExamPrepare.Hard.HJ2;

import java.util.Scanner;

public class CountCharacterTimes {
    public static void main(String[] args) {
        int count =0;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String find = sc.nextLine();
        if (input.length()==0){
            System.out.println(0);
            return;
        }
        char findChar = find.charAt(0);
        int anotherCase;
        int dis = 'a' - 'A';
        if (findChar > 'Z'){
            anotherCase = findChar - dis;
        }else {
            anotherCase = findChar + dis;
        }
        for (int i=0;i<input.length();i++){
            if (input.charAt(i)==findChar||input.charAt(i)==anotherCase){
                count++;
            }
        }
        System.out.println(count);
    }
}
