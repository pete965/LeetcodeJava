package Coding_Interview.Sword_Offer_022;
import Beans.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (root==null){
            return arrayList;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode pop=queue.remove();
            arrayList.add(pop.val);
            if (pop.left!=null){
                queue.add(pop.left);
            }
            if (pop.right!=null){
                queue.add(pop.right);
            }
        }
        return arrayList;
    }
}

