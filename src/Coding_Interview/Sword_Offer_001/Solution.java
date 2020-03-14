package Coding_Interview.Sword_Offer_001;

/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/

public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        int i;
        i=(2+3)/2;
        System.out.println(solution.Find(7,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
    }
    public boolean Find(int target, int [][] array) {
        int row=array.length;
        if (row==0){
            return false;
        }
        int col=array[0].length;

        if (row==1){
            if (col==0){
                return false;
            }
            if (col==1){
                return target==array[0][0];
            }
            int left=0,right=col-1;
            if (target>array[0][right]||target<array[0][left]){
                return false;
            }
            if (target==array[0][right]||target==array[0][left]){
                return true;
            }
            int mid=(left+right)/2;
            while (left!=right){
                if (array[0][mid]>target){
                    right=mid;
                    mid=(left+right)/2;
                }else if (array[0][mid]<target){
                    left=mid;
                    mid=(left+right)/2;
                }else{
                    return true;
                }
            }
            return false;
        }
        if (col==0){
            return false;
        }
        if (col==1){
            for (int i=0;i<row;i++){
                if (array[i][0]==target){
                    return true;
                }
            }
            return false;
        }

        int j=0;
        while(j<row&&array[j][0]<=target){
            j++;
        }
        for (int i=0;i<j;i++){
            int left=0,right=col-1;
            int mid=(left+right)/2;
            while (left!=right){
                if (array[i][left]==target||array[i][right]==target){
                    return true;
                }
                if (array[i][mid]>target){
                    if (right==mid){
                        break;
                    }
                    right=mid;
                    mid=(left+right)/2;
                }else if (array[i][mid]<target){
                    if (left==mid){
                        break;
                    }
                    left=mid;
                    mid=(left+right)/2;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}