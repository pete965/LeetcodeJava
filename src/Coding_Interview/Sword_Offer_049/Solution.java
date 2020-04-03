package Coding_Interview.Sword_Offer_049;

import java.util.Set;
import java.util.TreeSet;

/*
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
输入:
+2147483647
    1a33
输出:
2147483647
    0
 */
public class Solution{
    public int StrToInt(String str) {
        if (str.length() == 0 || "".equals(str)) {
            return 0;
        }
        boolean isNeg = false;
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            isNeg = true;
            str = str.substring(1);
        }
        char[] s = str.toCharArray();
        double res = 0;
        for (int i = 0; i < s.length; i++) {
            if (!Character.isDigit(s[i])) {
                return 0;
            } else {
                res += Math.pow(10, s.length - i - 1) * (s[i] - 48);
            }
        }
        if(isNeg==false) {
            if(res>Integer.MAX_VALUE) {
                return 0;
            }else {
                return (int)res;
            }
        }else {
            if((0-res)<Integer.MIN_VALUE) {
                return 0;
            }else {
                return (int)(0-res);
            }
        }
    }
}
