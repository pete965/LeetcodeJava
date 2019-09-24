package Tools;

public class Util {
    public static String listToString(ListNode deleteDuplication) {
        ListNode current=deleteDuplication;
        String output="{";
        while (current!=null){
            output+=current.val;
        }
        output+="}";
        return output;
    }

    public static  ListNode arrayToNode(int[] array) {
        if (array.length==0){
            return null;
        }
        ListNode head=new ListNode(array[0]);
        ListNode current=head;
        for (int i=1;i<array.length;i++){
            ListNode node=new ListNode(array[i]);
            current.next=node;
            current=current.next;
        }
        current.next=null;
        return head;
    }
}
