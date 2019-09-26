package Coding_Interview.Sword_Offer_061;

import Tools.TreeNode;

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
