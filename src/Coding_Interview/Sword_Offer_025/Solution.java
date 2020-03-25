package Coding_Interview.Sword_Offer_025;

/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
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
