package No_2_Add_Two_Numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Main {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        int carry = 0;
        ListNode output = new ListNode((l1.val+l2.val)%10);
        ListNode current = output;
        while(current1!=null||current2!=null){
            int a = (current1 != null) ? current1.val:0;
            int b = (current2 != null) ? current2.val:0;
            int value = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            ListNode listNode = new ListNode(value);
            current.next = listNode;
            current = current.next;
            if(current1!=null){
                current1 = current1.next;
            }
            if(current2!=null){
                current2 = current2.next;
            }
        }
        if(carry == 1){
            current.next = new ListNode(1);
        }
        return output.next;
    }
}