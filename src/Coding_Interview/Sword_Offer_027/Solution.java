package Coding_Interview.Sword_Offer_027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    private ArrayList<String> res = new ArrayList<>();
    private TreeSet<String> paths = new TreeSet<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.equals("")) {
            return res;
        }
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        visited = new boolean[strs.length];
        combination(strs, 0);
        res.addAll(paths);
        return res;
    }

    private void combination(char[] strs, int len) {
        if (len == strs.length) {
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(strs[i]);
                combination(strs, len + 1);
                //Duang ~ 回溯 - 状态重置
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
