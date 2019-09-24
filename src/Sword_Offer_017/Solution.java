package Sword_Offer_017;
import Tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2==null||root1==null){
            return false;
        }
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.add(root1);
        queue2.add(root2);
        while (!queue2.isEmpty()){
            if (queue1.isEmpty()){
                return false;
            }
            TreeNode pop2=queue2.remove();
            TreeNode pop1=queue1.remove();
            if (pop1.val!=pop2.val){
                if(root1.left!=null||root1.right!=null){
                    return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
                }else{
                    return false;
                }
            }
            if (pop2.left!=null){
                if (pop1.left!=null){
                    queue1.add(pop1.left);
                }else{
                    if(root1.left!=null||root1.right!=null){
                        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
                    }else{
                        return false;
                    }
                }
                queue2.add(pop2.left);
            }
            if (pop2.right!=null){
                if (pop1.right!=null){
                    queue1.add(pop1.right);
                }else{
                    if(root1.left!=null||root1.right!=null){
                        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
                    }else{
                        return false;
                    }
                }
                queue2.add(pop2.right);
            }
        }
        return true;
    }
}
