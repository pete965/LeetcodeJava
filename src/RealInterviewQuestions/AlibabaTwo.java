package RealInterviewQuestions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class AlibabaTwo {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[3][n];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        calculate(0,n-1,arrayList,matrix);
        System.out.println(ans);
    }
    public static void calculate(int start, int end, ArrayList<Integer> arrayList,int[][] matrix){
        for(int i=0;i<3;i++){
            arrayList.add(matrix[i][start]);
            if (start!=end){
                calculate(start+1,end,arrayList,matrix);
                arrayList.remove(arrayList.size()-1);
            }else{
                int local = 0;
                for (int j = 0; j<arrayList.size()-1;j++){
                    local+=Math.abs(arrayList.get(j)-arrayList.get(j+1));
                }
                System.out.println(arrayList.toString());
                System.out.println("Local Sum:"+local);

                if (ans == 0||local<ans){
                    ans=local;
                }
                System.out.println("Ans Now:"+ans);
                arrayList.remove(arrayList.size()-1);
            }
        }
    }
}

//6-六列
//        5 9 5 4 4 1
//        4 7 4 10 3 1
//        2 10 9 2 3 1
//7
//5 9 5 4 4 1 3
//4 7 4 10 3 1 4
//2 10 9 2 3 1 5
