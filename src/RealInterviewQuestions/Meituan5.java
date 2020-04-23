package RealInterviewQuestions;
//相似
//        时间限制：C/C++语言 1000MS；其他语言 3000MS
//        内存限制：C/C++语言 65536KB；其他语言 589824KB
//        题目描述：
//        两个数是相似的，当且仅当他们位与起来不为0。例如，3和5是相似的，因为3的二进制为011,5的二进制为101,他们位与起来为001不为0。
//
//        现在，给出序列a1,a2…an我们希望你找出，对于任意的i∈[1,n]，是否存在j∈[1,n]，使得ai,aj不相似。
//
//        输入
//        输入第一行包括一个整数n，代表序列a的长度
//
//        接下来一行n个数，空格隔开，代表序列a
//
//        1<=n<=100000,1<=ai<=106
//
//        输出
//        输出n个数。
//
//        如果对于i个数，存在j∈[1,n]，使得ai,aj不相似，输出1,否则输出-1
//
//
//        样例输入
//        4
//        3 5 6 1
//        样例输出
//        -1 -1 1 1
//
//        提示
//        样例解释：
//        唯一一对不相似的数是6和1,故6和1的答案为1,其余为-1。
import java.util.Scanner;

public class Meituan5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int[] output = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if ((nums[i]&nums[j])==0){
                    output[i] = 1;
                    output[j] = 1;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<n;i++){
            if (output[i]==1){
                stringBuilder.append("1");
            }else {
                stringBuilder.append("-1");
            }
            if (i!=n-1){
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}