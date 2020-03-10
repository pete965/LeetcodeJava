package Deep_Thought_Into_Java;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int pairs = scanner.nextInt();
        for(int i=0;i<pairs;i++){
            int count=0;
            int num = scanner.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j=0;j<num;i++){
                arrayList.add(scanner.nextInt());
            }
            for(int j=0;j<num;j++){
                for(int k=j+1;k<num;k++){
                    int one = arrayList.get(j);
                    int two = arrayList.get(k);
                    if ((one%two==0&&one/two==2)||(two%one==0&&two/one==2)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
