package Leetcode.Special_No_4_First_Unique_Number;

import java.util.*;

public class FirstUnique {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,4,5,6,7,8,10,10};
        FirstUnique firstUnique = new FirstUnique(nums);
        firstUnique.showFirstUnique();
//        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
//        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
//        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
//        firstUnique.showFirstUnique(); // return 17
//        for (int i=1;i<12;i++){
//            firstUnique.add(i);
//            firstUnique.showFirstUnique();
//        }
        firstUnique.add(8);
        firstUnique.showFirstUnique();
        for (int i=1;i<12;i++){
            firstUnique.add(i);
            firstUnique.showFirstUnique();
        }
        firstUnique.add(9);
        firstUnique.showFirstUnique();
    }
    HashMap<Integer,Node> hashMap = new HashMap<>();
    Node head;
    Node tail;
    Node cur;
    public FirstUnique(int[] nums) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        cur = head;
        for (int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int showFirstUnique() {
        if (this.head.next.next!=null){
//            System.out.println(this.head.next.val);
            return this.head.next.val;
        }else {
//            System.out.println(-1);
            return -1;
        }
    }

    public void add(int value) {
//        System.out.println("add:"+value);
        int current = value;
        if (hashMap.containsKey(current)){
            //hashmap中存在此关键字，说明以前出现过
            Node location = hashMap.get(current);
            if (location!=null) {
                if (location==cur){
                    cur = cur.pre;
                }
                //若此关键字存在于双向链表中，则准备将其删除
                //从双向链表中删除该节点
                Node previous = location.pre;
                Node nextNode = location.next;
                previous.next = nextNode;
                nextNode.pre = previous;
                hashMap.put(current, null);
            }
        }else {
            Node node = new Node(current);
            node.next = this.cur.next;
            node.next.pre = node;
            this.cur.next = node;
            node.pre = this.cur;
            this.cur = node;
            hashMap.put(current,node);
        }
    }
    private class Node{
        int val;
        Node pre;
        Node next;
        public Node(int val){
            this.val = val;
            next = null;
            pre = null;
        }
    }
}
