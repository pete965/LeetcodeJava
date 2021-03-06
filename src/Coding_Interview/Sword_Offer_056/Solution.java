package Coding_Interview.Sword_Offer_056;
import Beans.ListNode;
import Beans.Util;

/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] array=new int[]{1,1,1,1,1,1,1};
        System.out.println(Util.listToString(solution.deleteDuplication(Util.arrayToNode(array))));
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head=new ListNode(1);
        head.next=pHead;
        if (pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode current1=pHead.next;
        ListNode current2=head;
        while (current1!=null){
            if (current2.next.val!=current1.val){
                current2=current2.next;
                current1=current1.next;
            }else {
                while (current1!=null&&current2.next.val==current1.val){
                    current1=current1.next;
                }
                current2.next=current1;
                if (current1!=null){
                    current1=current1.next;
                }
            }
        }
        return head.next;
    }
}