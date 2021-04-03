package RealInterviewQuestions.Huawei;
import java.util.Scanner;

//给定一个单一的数字String，返回其中单一数字子串的个数
public class Test {
//    0 意味着matrix值还未被填充；1代表是单一数字子串；2代表不是
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int length = s.length();
        if (length == 0){
            System.out.println(0);
            return;
        }
        matrix = new int[length][length];
        for (int i = 0;i<length;i++){
            for (int j=i;j<length;j++){
                matrix[i][j] = calMatrixValue(i,j,s);
            }
        }
        int num = 0;
        for (int i = 0;i<length;i++){
            for (int j=i;j<length;j++){
                if (matrix[i][j]==1){
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    private static int calMatrixValue(int i, int j,String s) {
        if (matrix[i][j]!=0){
            return matrix[i][j];
        }
        if (i == j){
            return 1;
        }else {
            if (calMatrixValue(i,j-1,s)==1&&s.charAt(i)==s.charAt(j)){
                return 1;
            }else {
                return 2;
            }
        }
    }
}
