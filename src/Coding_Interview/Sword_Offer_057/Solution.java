package Coding_Interview.Sword_Offer_057;

import Tools.TreeLinkNode;
/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
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
