package Sowrd_Offer_004;
import Tools.TreeNode;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int split=pre[0];
        int leftLength = 0;
        int rightLength = 0;
        TreeNode root=new TreeNode(split);
        if (pre.length==1){
            root.left=null;
            root.right=null;
            return root;
        }
        for (int i=1;i<pre.length;i++){
            if (in[i]==split){
                leftLength=i;
                rightLength=pre.length-1-leftLength;
                break;
            }
        }
        int[] leftPre=new int[leftLength];
        int[] leftIn=new int[leftLength];
        int[] rightPre=new int[rightLength];
        int[] rightIn=new int[rightLength];

        for (int i=1;i<pre.length;i++){
            if (i<=leftLength){
                leftPre[i]=pre[i];
            }else{
                rightPre[i]=pre[i];
            }
        }
        for (int i=0;i<in.length;i++){
            if (i<leftLength){
                leftIn[i]=in[i];
            }else if (i>leftLength){
                rightIn[i]=in[i];
            }
        }
        root.left=reConstructBinaryTree(leftPre,leftIn);
        root.right=reConstructBinaryTree(rightPre,rightIn);
        return root;
    }
}