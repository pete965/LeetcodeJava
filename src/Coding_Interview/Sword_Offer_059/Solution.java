package Coding_Interview.Sword_Offer_059;

import Tools.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();

        if (pRoot==null){
            return arrayLists;
        }
        Stack<TreeNode> stack1 =new Stack<>();
        Stack<TreeNode> stack2 =new Stack<>();

        stack1.push(pRoot);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            ArrayList<Integer> arrayList1=new ArrayList<>();
            while (!stack1.isEmpty()){
                TreeNode pop=stack1.pop();
                arrayList1.add(pop.val);
                if (pop.left!=null){
                    stack2.push(pop.left);
                }
                if (pop.right!=null){
                    stack2.push(pop.right);
                }
            }
            if (arrayList1.size()!=0){
                arrayLists.add(arrayList1);
            }
            ArrayList<Integer> arrayList2=new ArrayList<>();
            while (!stack2.isEmpty()){
                TreeNode pop=stack2.pop();
                arrayList2.add(pop.val);
                if (pop.right!=null){
                    stack1.push(pop.right);
                }
                if (pop.left!=null){
                    stack1.push(pop.left);
                }
            }
            if (arrayList2.size()!=0){
                arrayLists.add(arrayList2);
            }
        }
        return arrayLists;
    }
}
