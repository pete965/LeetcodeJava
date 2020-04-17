package Beans;

import java.util.LinkedList;
import java.util.Queue;

public class Util {
    public static String listToString(ListNode deleteDuplication) {
        ListNode current=deleteDuplication;
        String output="{";
        while (current!=null){
            output+=current.val;
        }
        output+="}";
//
        return output;
    }

    public static  ListNode arrayToNode(int[] array) {
        if (array.length==0){
            return null;
        }
        ListNode head=new ListNode(array[0]);
        ListNode current=head;
        for (int i=1;i<array.length;i++){
            ListNode node=new ListNode(array[i]);
            current.next=node;
            current=current.next;
        }
        current.next=null;
        return head;
    }
    public static String treeToPreString(TreeNode root){
        return null;
    }
    public static String treeToInString(TreeNode root){
        return null;
    }
    public static String treeToPostString(TreeNode root){
        return null;
    }
    public static String treeToBreString(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        String output="";
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode pop=queue.remove();
            output+=pop.val;
            if (pop.left!=null){
                queue.add(pop.left);
            }
            if (pop.right!=null){
                queue.add(pop.right);
            }
        }
        return output;
    }
}
