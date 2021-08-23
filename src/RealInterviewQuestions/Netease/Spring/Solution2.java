package RealInterviewQuestions.Netease.Spring;

import Beans.ListNode;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */
//两个非空链表，表示两个整数，正负号在首个节点位置表示，求它们的差值，即a-b，同样是链表表示
public class Solution2 {
    public ListNode minusList(ListNode minuendList, ListNode subtrahendList) {
        // write code here

        ListNode output = null;
        if (minuendList.val == 0) {
            subtrahendList.val = -subtrahendList.val;
            return subtrahendList;
        }
        if (subtrahendList.val == 0) {
            return minuendList;
        }


        boolean reverse = false;
        if (minuendList.val * subtrahendList.val > 0) {
//            同号，正数减法
            reverse = compareTwoNum(minuendList, subtrahendList);
            if ((reverse && minuendList.val>0)||(!reverse&&minuendList.val<0)){
                ListNode mid = minuendList;
                minuendList = subtrahendList;
                subtrahendList = mid;
            }
            minuendList.val = Math.abs(minuendList.val);
            subtrahendList.val = Math.abs(minuendList.val);
            minuendList = reverseList(minuendList);
            subtrahendList = reverseList(subtrahendList);
            ListNode current1 = minuendList;
            ListNode current2 = subtrahendList;
            ListNode last = null;
            boolean flag = false;
            while (!(current1 == null && current2 == null)) {
                int value = 0;
                if (flag){
                    value--;
                }
                if (current1 == null) {
                    value-=current2.val;
                } else if (current2 == null) {
                    value+=current1.val;
                } else {
                    value+=current1.val;
                    value-=current2.val;
                }
                if (value<0){
                    flag=true;
                    value+=10;
                }
                ListNode newNode = new ListNode(value);
                newNode.next = last;
                last = newNode;
            }
            output = reverseList(last);
        } else {
//            不同号,正数加法
            if (minuendList.val < 0) {
                reverse = true;
            }
            minuendList.val = Math.abs(minuendList.val);
            subtrahendList.val = Math.abs(minuendList.val);
            minuendList = reverseList(minuendList);
            subtrahendList = reverseList(subtrahendList);
            ListNode current1 = minuendList;
            ListNode current2 = subtrahendList;
            ListNode last = null;
            boolean flag = false;
            while (!(current1 == null && current2 == null)) {
                int value = 0;
                if (flag) {
                    value++;
                }
                if (current1 == null) {
                    value += current2.val;
                } else if (current2 == null) {
                    value += current1.val;
                } else {
                    value += current1.val;
                    value += current2.val;
                }
                if (value >= 10) {
                    flag = true;
                    value -= 10;
                } else {
                    flag = false;
                }
                ListNode newNode = new ListNode(value);
                newNode.next = last;
                last = newNode;
            }
            if (flag) {
                ListNode newNode = new ListNode(1);
                newNode.next = last;
                last = newNode;
            }
            output = reverseList(last);
        }
        return output;
    }

    private ListNode reverseList(ListNode minuendList) {
        ListNode current = minuendList;
        ListNode next;
        ListNode last = null;
        while (current!=null){
            next = current.next;
            current.next = last;
            last = current;
            current = next;
        }
        return last;
    }

    private boolean compareTwoNum(ListNode minuendList, ListNode subtrahendList) {
        if (minuendList.val>0){
//            都是正数
            int firstLength = getLength(minuendList);
            int secondLenth = getLength(subtrahendList);
            if (firstLength!=secondLenth){
                return firstLength<secondLenth;
            }else {
                ListNode current1 = minuendList;
                ListNode current2 = subtrahendList;
                while (current1!=null){
                    if (current1!=current2){
                        return current1.val<current2.val;
                    }
                }
                return false;
            }
        }else {
//            都是负数
            minuendList.val = -minuendList.val;
            subtrahendList.val = -subtrahendList.val;
            return !compareTwoNum(minuendList,subtrahendList);
        }
    }

    private int getLength(ListNode minuendList) {
        int length = 0;
        ListNode current = minuendList;
        while (current!=null){
            length++;
            current=current.next;
        }
        return length;
    }
}
