package Sowrd_Offer_004;
import Tools.TreeNode;
import Tools.Util;

public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(Util.treeToBreString(solution.reConstructBinaryTree(new int[]{1,2,4,3,5,6},new int[]{4,2,1,5,3,6})));
        System.out.println(Util.treeToBreString(solution.reConstructBinaryTree(new int[]{1,2,3,4,5,6,7},new int[]{3,2,4,1,6,5,7})));
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0){
            return null;
        }
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
                leftPre[i-1]=pre[i];
            }else{
                rightPre[i-leftLength-1]=pre[i];
            }
        }
        for (int i=0;i<in.length;i++){
            if (i<leftLength){
                leftIn[i]=in[i];
            }else if (i>leftLength){
                rightIn[i-leftLength-1]=in[i];
            }
        }
        root.left=reConstructBinaryTree(leftPre,leftIn);
        root.right=reConstructBinaryTree(rightPre,rightIn);
        return root;
    }
}