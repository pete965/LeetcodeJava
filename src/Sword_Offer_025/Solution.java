package Sword_Offer_025;

class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null){
            RandomListNode node = null;
            return node;
        }
        RandomListNode current = pHead;
        while(current!=null){
            RandomListNode node = new RandomListNode(current.label);
            node.next=current.next;
            current.next = node;
            current=current.next.next;
        }
        current = pHead;
        while(current!=null){
            RandomListNode next = current.next;
            if(current.random==null){
                next.random = null;
            }else{
                next.random = current.random.next;
            }
            current=current.next.next;
        }
        current=pHead;
        RandomListNode output=current.next;
        while(current.next.next!=null){
            RandomListNode mid = current.next;
            current.next = current.next.next;
            mid.next=current.next.next;
            current=current.next;
        }
        current.next=null;
        return output;
    }
}
