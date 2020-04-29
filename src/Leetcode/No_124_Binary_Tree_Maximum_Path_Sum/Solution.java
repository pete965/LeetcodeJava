package Leetcode.No_124_Binary_Tree_Maximum_Path_Sum;

import Beans.TreeNode;
import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        testCase 3
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(-4);
        root.left=node1;
        node1.left=node2;
        node2.right=node3;
        node3.left=node4;

//        testCase 2
//        TreeNode root = new TreeNode(2);
//        TreeNode node1 = new TreeNode(-1);
//        TreeNode node2 = new TreeNode(-2);
//        root.left = node1;
//        root.right = node2;

//        testCase 1
//        TreeNode root = new TreeNode(-10);
//        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(20);
//        root.left = node1;
//        root.right = node2;
//        TreeNode node3 = new TreeNode(15);
//        TreeNode node4 = new TreeNode(7);
//        node2.left=node3;
//        node2.right=node4;
        System.out.println(solution.maxPathSum(root));
    }
    int output = 0;
    HashMap<TreeNode,Integer> hashMap = new HashMap<>();
    public int maxPathSum(TreeNode root) {
        calPath(root);
        calMax(root);
        return output;
    }

    private void calMax(TreeNode root) {
        if (root==null){
            return;
        }
        int localMax = 0;
        int leftLength = 0;
        int rightLength = 0;
        if (hashMap.containsKey(root.left)){
            leftLength=hashMap.get(root.left);
        }
        if (hashMap.containsKey(root.right)){
            rightLength=hashMap.get(root.right);
        }
        localMax = root.val;
        localMax = Math.max(localMax,leftLength+root.val);
        localMax = Math.max(localMax,leftLength+root.val+rightLength);
        localMax = Math.max(localMax,root.val+rightLength);
//        System.out.println("For node with value"+root.val+" LocalMax:"+localMax);
        if (output==0){
            output = localMax;
        }else {
            output = Math.max(localMax,output);
        }
        calMax(root.left);
        calMax(root.right);
    }

    private int calPath(TreeNode node) {
        if (node==null){
            return 0;
        }
        int value = 0;
        if (node.left==null){
            if (node.right==null){
                value=node.val;
            }else {
                value=node.val+calPath(node.right);
            }
        }else {
            if (node.right==null){
                value=node.val+calPath(node.left);
            }else {
                value=Math.max(node.val+calPath(node.left),node.val+calPath(node.right));
            }
        }
        value=Math.max(value,node.val);
        hashMap.put(node,value);
//        System.out.println("For node with value"+node.val+" Length:"+value);
        return value;
    }
}
