package HuaweiMachineExamPrepare.Medium.HJ40;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int isLetter=0,isDigit=0,isWhitespace=0,isQt=0;
            char[] str = sc.nextLine().toCharArray();
            for(int i=0;i<str.length;i++){
                char a = str[i];
                if(Character.isLetter(a))
                    isLetter++;
                else if(Character.isDigit(a))
                    isDigit++;
                else if(Character.isWhitespace(a))
                    isWhitespace++;
                else isQt++;
            }
            System.out.println(isLetter);
            System.out.println(isWhitespace);
            System.out.println(isDigit);
            System.out.println(isQt);
        }
    }
}
