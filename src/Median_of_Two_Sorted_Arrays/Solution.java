package Median_of_Two_Sorted_Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leng = nums1.length + nums2.length;
        if (leng%2==0){
            return 0.5*(getn(leng/2,nums1,nums2)+getn((leng/2)+1,nums1,nums2));
        }else{
            return getn((leng+1)/2,nums1,nums2);
        }
    }
    public int getn(int n,int[] nums1, int[] nums2){
        int output=0;
        int i=0,j=0;
        while(i+j<n){
            if (i==nums1.length){
                output = nums2[j];
                j++;
                continue;
            }
            if (j==nums2.length){
                output=nums1[i];
                i++;
                continue;
            }
            if (nums1[i]<nums2[j]){
                output = nums1[i];
                i++;
            }else{
                output = nums2[j];
                j++;
            }
        }
        return output;
    }
}

//
//leetcode解法思路：中位数即找一个位置将整个数组分成两部分，即，将长数组分为两部分（此时短数组在哪里切分是确定的，因为总长度一定）
//为了找到这个分隔长数组最好的点，我们用二分查找的方法进行查找，可以达到log(m+n)的复杂度