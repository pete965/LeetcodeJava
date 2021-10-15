package HuaweiMachineExamPrepare.Medium.HJ35;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            for (int i=0;i<n;i++){
                lists.add(new ArrayList<>());
            }
            int count = 1;
            for (int i=0;i<n;i++){
                for (int j=i;j>=0;j--){
                    lists.get(j).add(count);
                    count++;
                }
            }
            for (ArrayList<Integer> list : lists) {
                for (Integer integer : list) {
                    System.out.print(integer);
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
        }
    }
}
