package Coding_Interview.Sword_Offer_040;

import java.util.HashMap;

/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 */
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if (length==0||length==1){
            return;
        }
        num1[0] = -1;
        num2[0] = -1;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<array.length;i++){
            int now = array[i];
            if (hashMap.containsKey(now)){
                hashMap.put(now,hashMap.get(now)+1);
            }else {
                hashMap.put(now,1);
            }
        }
        for (Integer integer:hashMap.keySet()){
            if (hashMap.get(integer)==1&&num1[0]==-1){
                num1[0]=integer;
            }else if(hashMap.get(integer)==1&&num1[0]!=-1){
                num2[0]=integer;
            }
        }
    }
}
