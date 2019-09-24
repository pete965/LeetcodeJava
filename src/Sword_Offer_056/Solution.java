package Sword_Offer_056;
import Tools.ListNode;
import Tools.Util;

public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        int[] array=new int[]{1,1,1,1,1,1,1};
        System.out.println(Util.listToString(solution.deleteDuplication(Util.arrayToNode(array))));
    }

//    private String tostring(ListNode deleteDuplication) {
//        ListNode current=deleteDuplication;
//        String output="{";
//        while (current!=null){
//            output+=current.val;
//        }
//        output+="}";
//        return output;
//    }
//
//    private  ListNode toNode(int[] array) {
//        if (array.length==0){
//            return null;
//        }
//        ListNode head=new ListNode(array[0]);
//        ListNode current=head;
//        for (int i=1;i<array.length;i++){
//            ListNode node=new ListNode(array[i]);
//            current.next=node;
//            current=current.next;
//        }
//        current.next=null;
//        return head;
//    }

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