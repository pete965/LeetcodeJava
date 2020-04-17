package Coding_Interview.Sword_Offer_061;
/*
请实现两个函数，分别用来序列化和反序列化二叉树
二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过某种符号表示空节点（#），
以 ！ 表示一个结点值的结束（value!）。
二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
import Beans.TreeNode;

public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        TreeNode root=new TreeNode(1);
        TreeNode node=new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        root.left=node;
        node.left=node1;
        System.out.println(solution.Serialize(root));
        System.out.println(solution.Serialize(solution.Deserialize("1,2,3,4,#,6,7,#,#,#,#,#,#")));
    }
    public int index = -1;
    String Serialize(TreeNode root) {
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
    TreeNode Deserialize(String str) {
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
