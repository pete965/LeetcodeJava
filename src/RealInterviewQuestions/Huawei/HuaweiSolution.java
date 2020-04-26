package RealInterviewQuestions.Huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HuaweiSolution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(scanner.hasNextInt()){
            arrayList.add(scanner.nextInt());
        }
        int amount=0;
        int count = 0;
        for(int i=1;i<=m;i++){
            int mul = 0;
            for (int j=1;j<=i;j++){
                if(i%j==0){
                    mul++;
                }
            }
            if (mul>2){
                amount+=getNthLow(arrayList,i,count);
                count++;
            }
        }
        System.out.println(amount);
    }

    private static int getNthLow(ArrayList<Integer> arrayList, int i, int count) {
        int[] input = new int[i];
        for (int j=0;j<i;j++){
            input[j]=arrayList.get(j);
        }

        for(int j=0;j<count;j++){
            for(int k=0;k<i;k++){
                if ((2*(k+1)-1<=i&&input[2*(k+1)-1]<input[i])||(2*(k+1)<=i&&input[2*(k+1)]<input[i])){
                    if (input[2*(k+1)-1]<input[2*(k+1)]){
                        exchange(k,2*(k+1)-1,input);
                    }else{
                        exchange(k,2*(k+1),input);
                    }
                }
            }
            i--;
        }
        return input[0];
    }

    private static void exchange(int i, int i1, int[] input) {
        int mid=input[i];
        input[i]=input[i1];
        input[i1]=mid;
    }
}
