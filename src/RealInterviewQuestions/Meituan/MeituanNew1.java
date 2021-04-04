package RealInterviewQuestions.Meituan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

//一天，小美在写英语作业时，发现了一个十分优美的字符串：这个字符串没有任何两个字符相同。于是，小美随手写下了一个字符串，她想知道这个字符串的的所有子序列，有多少个是优美的。由于答案可能会很大，输出对20210101取模后的结果。
//
//        一个字符串的子序列定义为：原字符串删除0个或多个字符后剩下的字符保持原有顺序拼接组成的字符串为原串的子序列。如：ab是acba的子序列，但bc则不是。在本题中。空串也为原串的子序列。
//
//        两个子序列不相同，当且仅当他们对应原串的下标不相同。如aab则含有两个子序列ab。
//输入仅一行一个仅由小写字母组成的字符串。
//
//        设字符串长度为len：
//
//        1<=len<=1000000;
public class MeituanNew1 {
    static long number = 1L;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        long length = input.length();
        ArrayList<Character> subString = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for (int i=0;i<length;i++){
            subString.add(input.charAt(i));
            set.add(input.charAt(i));
            checkAndRec(input,i,subString,set);
            subString.remove(subString.size() - 1);
            set.remove(input.charAt(i));
        }
        System.out.println(number%20210101L);
    }

    private static void checkAndRec(String input, int index, ArrayList<Character> subString, HashSet<Character> set) {
        number++;
        System.out.println(subString.toString());
        for (int i=index+1;i<input.length();i++){
            Character newCharacter = input.charAt(i);
            if (!set.contains(newCharacter)){
                subString.add(newCharacter);
                set.add(newCharacter);
                checkAndRec(input,i,subString,set);
                subString.remove(subString.size() - 1);
                set.remove(newCharacter);
            }
        }
    }
}
