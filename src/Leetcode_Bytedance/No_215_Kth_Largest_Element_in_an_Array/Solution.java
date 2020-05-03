package Leetcode_Bytedance.No_215_Kth_Largest_Element_in_an_Array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,7,2,6,3,5,4};
        System.out.println(solution.findKthLargest(nums,2));
    }
    public int findKthLargest(int[] nums, int k) {
        int output = 0;
        for (int i=0;i<k;i++){
            output=makeHeap(nums,nums.length-i-1);
        }
        return output;
    }
    private int makeHeap(int[] input, int index) {
        for (int i=index;i>=0;i--){
            int rootIndex = 0;
            if (i%2==0){
                rootIndex = (i-2)/2;
            }else {
                rootIndex = (i-1)/2;
            }
            if ((rootIndex>=0&&input[rootIndex]<input[i])){
                exchange(i,rootIndex,input);
            }
        }
        exchange(0,index,input);
        return input[index];
    }
    private void exchange(int i, int i1, int[] input) {
        int mid=input[i];
        input[i]=input[i1];
        input[i1]=mid;
    }
}
