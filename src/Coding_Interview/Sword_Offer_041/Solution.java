package Coding_Interview.Sword_Offer_041;

import java.util.ArrayList;

/*
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.FindContinuousSequence(10).toString());
    }
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum == 0||sum==1){
            return arrayLists;
        }
        for (int i = sum;i>1;i--){
            if (i%2==0&&(2*sum)%i==0){
                int midTwoSum = 2*sum/i;
                if (midTwoSum%2==1){
                    int left = (midTwoSum-1)/2;
                    int right = left + 1;
                    if (right-i/2>=1&&left+i/2<=sum){
                        for (int j=right-i/2;j<=left+i/2;j++){
                            arrayList.add(j);
                        }
                        arrayLists.add(new ArrayList<>(arrayList));
                        arrayList.clear();
                    }
                }
            }else{
                if (sum%i==0){
                    int mid = sum/i;
                    if(mid-(i-1)/2>=1&&mid+(i-1)/2<=sum){
                        for (int j=mid-(i-1)/2;j<=mid+(i-1)/2;j++){
                            arrayList.add(j);
                        }
                        arrayLists.add(new ArrayList<>(arrayList));
                        arrayList.clear();
                    }
                }
            }
        }
        return arrayLists;
    }


}
