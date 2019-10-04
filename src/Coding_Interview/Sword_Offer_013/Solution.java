package Coding_Interview.Sword_Offer_013;

public class Solution {
    public void reOrderArray(int [] array) {
        int length=array.length;
        if (length==0||length==1){
            return;
        }
        for (int i=0;i<length;i++){
            if (array[i]%2==0){
                for (int j=i+1;j<length;j++){
                    if (array[j]%2==1){
                        int temp=array[j];
                        for (int k=j-1;k>=i;k--){
                            array[k+1]=array[k];
                        }
                        array[i]=temp;
                        break;
                    }
                }
            }
        }
    }
}
