package No_138_Copy_List_with_Random_Pointer;

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            Node node = null;
            return node;
        }
        Node current = head;
        while(current!=null){
            Node node = new Node(current.val,current.next,null);
            current.next = node;
            current=current.next.next;
        }
        current = head;
        while(current!=null){
            Node next = current.next;
            if(current.random==null){
                next.random = null;
            }else{
                next.random = current.random.next;
            }
            current=current.next.next;
        }
        current=head;
        Node output=current.next;
        while(current.next.next!=null){
            Node mid = current.next;
            current.next = current.next.next;
            mid.next=current.next.next;
            current=current.next;
        }
        current.next=null;
        return output;
    }
}