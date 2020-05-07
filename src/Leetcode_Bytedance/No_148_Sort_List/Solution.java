package Leetcode_Bytedance.No_148_Sort_List;

import Beans.ListNode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null){
            return head;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val>o2.val){
                    return 1;
                }else if (o1.val<o2.val){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        while (head!=null){
            priorityQueue.add(head);
            head=head.next;
        }
        Iterator<ListNode> iterator = priorityQueue.iterator();
        ListNode listNode = iterator.next();
        ListNode current = listNode;
        while (priorityQueue.size()>0){
            current.next = priorityQueue.poll();
            current=current.next;
        }
        current.next = null;
        return listNode;
    }
}
