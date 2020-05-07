package Leetcode_Bytedance.No_103_Binary_Tree_Zigzag_Level_Order_Traversal;

import Beans.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left=root1;
        root.right=root2;
        root2.left=root3;
        root2.right=root4;
        Solution solution = new Solution();
        solution.zigzagLevelOrder(root);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return lists;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
//            System.out.println("Another layer");
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode current = queue.poll();
                list.add(current.val);
//                System.out.println("add:"+current.val);
                if (current.left!=null){
                    queue.offer(current.left);
                }
                if (current.right!=null){
                    queue.offer(current.right);
                }
            }
            if (lists.size()%2!=0){
                Collections.reverse(list);
            }
//            System.out.println(list.toString());
            lists.add(list);
        }
        return lists;
    }
}
