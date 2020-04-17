package Leetcode_Bytedance.No_21_Merge_Two_Sorted_Lists;

import Util.ArrayToList;
import Util.PrintList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = ArrayToList.convert(new int[]{1,2,4});
        ListNode listNode2 =ArrayToList.convert(new int[]{1,3,4});
        PrintList.printList(solution.mergeTwoLists(listNode1,listNode2));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1!=null||l2!=null){
            if (l1==null){
                current.next = l2;
                l2 = l2.next;
            }else if (l2 == null){
                current.next = l1;
                l1 = l1.next;
            }else if (l1.val>l2.val){
                current.next = l2;
                l2 = l2.next;
            }else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        return head.next;
    }
}
