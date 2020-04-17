package Util;

import Leetcode_Bytedance.No_21_Merge_Two_Sorted_Lists.ListNode;

public class PrintList {
    public static void printList(ListNode listNode){
        System.out.println("------Print List------");
        while (listNode!=null){
            System.out.print(listNode.val+"->");
            listNode=listNode.next;
        }
        System.out.print("null");
        System.out.println("\n----------End----------");
    }

    public static void printNode(ListNode middleNode) {
        if (middleNode ==null){
            System.out.println("This node is null");
        }else {
            System.out.println("This node is "+middleNode.val);
        }
    }
}
