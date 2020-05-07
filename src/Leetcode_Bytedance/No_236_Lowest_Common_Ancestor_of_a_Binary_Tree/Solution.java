package Leetcode_Bytedance.No_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import Beans.TreeNode;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        System.out.println("Common ans: "+ solution.lowestCommonAncestor(root,node1,node2).val);
    }
    //0代表向左子树前进，1代表向右子树前进
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<Integer> arrayList1;
    ArrayList<Integer> arrayList2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root,p,q);
        TreeNode current = root;
//        System.out.println(arrayList1.toString());
//        System.out.println(arrayList2.toString());
        for (int i=0;i<Math.min(arrayList1.size(),arrayList2.size());i++){
            if (arrayList2.get(i)!=arrayList1.get(i)){
                return current;
            }else {
                if (arrayList1.get(i)==0){
                    current = current.left;
                }else {
                    current = current.right;
                }
            }
        }
        return current;
    }
    public void traverse(TreeNode root, TreeNode p, TreeNode q){
        if (root==null){
            return;
        }
        if (root.val==p.val){
            arrayList1=(ArrayList<Integer>) arrayList.clone();
//            System.out.println("P found "+p.val);
        }
        if (root.val==q.val){
//            System.out.println(arrayList.toString());
            arrayList2=(ArrayList<Integer>) arrayList.clone();
//            System.out.println("Q found "+q.val);
        }
        arrayList.add(0);
//        System.out.println("Go left");
        traverse(root.left,p,q);
        arrayList.remove(arrayList.size()-1);
        arrayList.add(1);
//        System.out.println("Go right");
        traverse(root.right,p,q);
        arrayList.remove(arrayList.size()-1);
    }
}
