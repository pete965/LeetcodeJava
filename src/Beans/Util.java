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
    public static ListNode arrayToCicleList(int[] array,int index){
        ListNode cycle = new ListNode(array[index]);
        ListNode head=new ListNode(array[0]);
        ListNode current=head;
        for (int i=1;i<array.length&&i!=index;i++){
            ListNode node=new ListNode(array[i]);
            current.next=node;
            current=current.next;
        }
        current.next=cycle;
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
            output+=(pop.val)+",";
            if (pop.left!=null){
                queue.add(pop.left);
            }
            if (pop.right!=null){
                queue.add(pop.right);
            }
        }
        return output;
    }
    public static int index = -1;
    static String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    static TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
