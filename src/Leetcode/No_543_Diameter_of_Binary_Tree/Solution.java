package Leetcode.No_543_Diameter_of_Binary_Tree;

import Beans.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(root));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), height(root.left)+height(root.right));
    }

    private int height(TreeNode right) {
        if (right==null){
            return 0;
        }else {
            return Math.max(height(right.right),height(right.left))+1;
        }
    }
}
