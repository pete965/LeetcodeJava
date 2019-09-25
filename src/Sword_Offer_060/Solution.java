package Sword_Offer_060;

import Tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();

        if (pRoot==null){
            return arrayLists;
        }
        Queue<TreeNode> queue1 =new LinkedList<>();
        Queue<TreeNode> queue2 =new LinkedList<>();

        queue1.offer(pRoot);
        while (!queue1.isEmpty()||!queue1.isEmpty()){
            ArrayList<Integer> arrayList1=new ArrayList<>();
            while (!queue1.isEmpty()){
                TreeNode pop=queue1.remove();
                arrayList1.add(pop.val);
                if (pop.left!=null){
                    queue2.offer(pop.left);
                }
                if (pop.right!=null){
                    queue2.offer(pop.right);
                }
            }
            if (arrayList1.size()!=0){
                arrayLists.add(arrayList1);
            }
            ArrayList<Integer> arrayList2=new ArrayList<>();
            while (!queue2.isEmpty()){
                TreeNode pop=queue2.remove();
                arrayList2.add(pop.val);
                if (pop.left!=null){
                    queue1.offer(pop.left);
                }
                if (pop.right!=null){
                    queue1.offer(pop.right);
                }
            }
            if (arrayList2.size()!=0){
                arrayLists.add(arrayList2);
            }
        }
        return arrayLists;
    }
}
