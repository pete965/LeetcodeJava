package Coding_Interview.Sword_Offer_063;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5,2,3,4,1,6,7,0,8};
        for (int i=0;i<nums.length;i++){
            solution.Insert(nums[i]);
            Double res = solution.GetMedian();
//            System.out.println("Insert:"+nums[i]);
//            System.out.println(solution.GetMedian());
        }
    }
    LinkedList<Integer> linkedList = new LinkedList<>();
    int length = 0;
    public void Insert(Integer num) {
        if (linkedList.size()==0){
            linkedList.add(num);
        }else{
            int index = Collections.binarySearch(linkedList,num);
            if (index>=0) {
                linkedList.add(index,num);
            } else {
                linkedList.add(-(index+1),num);
            }
        }
        length++;
    }

    public Double GetMedian() {
        if (length%2!=0){
            return Double.valueOf(linkedList.get((length-1)/2));
        }else {
            return (Double.valueOf(linkedList.get(length/2))+Double.valueOf(linkedList.get(length/2-1)))/2;
        }
    }
}

/*
Leetcode拓展：
        1.If all integer numbers from the stream are between 0 and 100, how would you optimize it?
        2.If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*/