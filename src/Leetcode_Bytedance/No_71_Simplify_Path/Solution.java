package Leetcode_Bytedance.No_71_Simplify_Path;

import java.util.*;

public class Solution {
//    要求总结：
//    1.字符串末尾没有斜杠
//    2.多个连续斜杠用一个斜杠代替
//    3.由根目录不能向上一级，所以碰到这种情况时，返回结果认为依然是根目录
//    4.一个点.表示当前目录
//    5.两个连续的点..表示父目录
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(solution.simplifyPath("/..."));
    }
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String res = "";
        for (String dir : stack) {
            res = "/" + dir + res;
        }
        return res.isEmpty() ? "/" : res;
    }

}
