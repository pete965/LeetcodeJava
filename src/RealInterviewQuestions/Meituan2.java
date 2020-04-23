package RealInterviewQuestions;

//规范化货币
//        时间限制：C/C++语言 1000MS；其他语言 3000MS
//        内存限制：C/C++语言 65536KB；其他语言 589824KB
//        题目描述：
//        货币数值的规范化是金融公司的一个问题，现在你需要写一个程序来解决这一问题：
//
//        1.货币数值的整数部分要求每3位加一个英文逗号','（不含引号）。例如12345678应该规范化为12,345,678
//
//        2.货币数值最多只有两位小数，如果有多余的小数位数应当舍去。注意，不是四舍五入。
//
//        3.负数代表欠款，在规范化后应当在数值两端加上括号 '(' 和 ')' ，然后省略掉负号。
//
//        4.应当在数值前面，前括号后面（如果有括号的话）加上金钱符号'$'（不含引号）
//
//        现在给你一个数字，请你规范化这一数字
//
//        输入
//        输入包含多种数据，每组数据一行一个数字，可能为小数，整数，负整数，负小数或者零。
//
//        数据保证数字没有前导0，保证不会出现欠0元的情况
//
//        输出
//        输出规范化后的内容
//
//
//        样例输入
//        203323
//        0.0
//        0.000000
//        0.009212121
//        343444323.32432
//        -12344.1
//        -12345678.9
//        样例输出
//        $203,323.00
//        $0.00
//        $0.00
//        $0.00
//        $343,444,323.32
//        ($12,344.10)
//        ($12,345,678.90)
//
//        提示
//        范围
//        每个字符串长度不会超过100
import java.util.Scanner;

public class Meituan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            boolean neg = false;
            boolean flo = false;
            int offset;
            String s = scanner.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("$");
            int j=0;
            int count=2;
            for (int i = 0;i<s.length();i++){
                if (s.charAt(i)=='-'){
                    neg=true;
                }else if (s.charAt(i)=='.'){
                    flo = true;
                    j=i;
                    stringBuilder.append(".");
                    break;
                }else {
                    stringBuilder.append(s.charAt(i));
                }
            }

            if (!flo){
                stringBuilder.append(".00");
            }else {
                for (int i=j+1;count>0;i++){
                    count--;
                    if (i<s.length()){
                        stringBuilder.append(s.charAt(i));
                    }else {
                        stringBuilder.append('0');
                    }
                }
            }
            if (j==0){
                j=stringBuilder.length()-3;
            }else {
                j++;
            }
            if (neg){
                stringBuilder.insert(0,"(");
                stringBuilder.append(")");
                offset=3;
            }else {
                offset=2;
            }
            for (int i=j-3;i>=offset;i-=3){
                stringBuilder.insert(i,",");
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
