package Leetcode.No_993_Cousins_in_Binary_Tree;

import Beans.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (x==y){
            return false;
        }
        if (root==null){
            return false;
        }
        queue.offer(root);
        if (x==root.val||y==root.val){
            return false;
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean a = false;
            boolean b = false;
            for (int i=0;i<size;i++){
                TreeNode current = queue.poll();
                if (current.val==x){
                    a=true;
                }
                if (current.val==y){
                    b=true;
                }
                if (current.left!=null&&current.right!=null){
                    if (current.left.val==x&&current.right.val==y){
                        return false;
                    }
                    if (current.left.val==y&&current.right.val==x){
                        return false;
                    }
                }
                if (current.left!=null){
                    queue.offer(current.left);

                }
                if (current.right!=null){
                    queue.offer(current.right);

                }
            }
            if (a&&b){
                return true;
            }
        }
        return false;
    }
}
