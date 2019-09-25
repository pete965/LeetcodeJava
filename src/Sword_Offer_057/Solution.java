package Sword_Offer_057;

import Tools.TreeLinkNode;

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //edge situation
        if (pNode==null){
            return null;
        }
        //root node
        if (pNode.next==null){
            if (pNode.right==null){
                return null;
            }
            TreeLinkNode current=pNode.right;
            while (current.left!=null){
                current=current.left;
            }
            return current;
        }
        //leaf node
        if (pNode.left==null&&pNode.right==null){
            while (pNode.next.left!=pNode){
                pNode=pNode.next;
                if (pNode.next==null){
                    break;
                }
            }
            return pNode.next;
        }else{
            //non-leaf nor root node
            if (pNode.right!=null){
                TreeLinkNode current=pNode.right;
                while (current.left!=null){
                    current=current.left;
                }
                return current;
            }else{
                while (pNode.next.left!=pNode){
                    pNode=pNode.next;
                    if (pNode.next==null){
                        break;
                    }
                }
                return pNode.next;
            }
        }
    }
}
