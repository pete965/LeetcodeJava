package Sword_Offer_023;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] test = new int[]{4,8,6,12,16,14,10};
        System.out.println(""+solution.isBinarySequence(test));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0){
            return false;
        }
        return isBinarySequence(sequence);
    }
    boolean isBinarySequence(int[] sequence){
        int length = sequence.length;
        String sequenceString = "";
        for (int i=0;i<length;i++){
            sequenceString+=sequence[i];
        }
        System.out.println(sequenceString);
        if (length==0||length==1||length==2){
            System.out.println("Too short, true!"+sequence.length);
            return true;
        }else{
            int root=sequence[length-1];
            int split = 0;
            for (int i=0;i<length-1;i++){
                if (sequence[i]<root){
                    split++;
                }else{
                    break;
                }
            }
            System.out.println("Root is:"+root);
            System.out.println("Split is:"+split);
            if(!validate(sequence,split,root)){
                System.out.println("Validate not apssed");
                System.out.println("Root is:"+root);
                return false;
            }else{
                String frontString = "";
                String endString = "";
                int[] front = new int[split];
                int[] end=new int[length-split-1];
                for (int i=0;i<split;i++){
                    front[i]=sequence[i];
                    frontString+=front[i];
                }
                for(int j=0;j<length-split-1;j++){
                    end[j]=sequence[j+split];
                    endString+=end[j];
                }
                System.out.println("Front is:"+frontString);
                System.out.println("End is:"+endString);
                return isBinarySequence(front)&&isBinarySequence(end);
            }
        }
    }

    private boolean validate(int[] sequence, int split,int root) {
        for (int i=split;i<sequence.length-1;i++){
            if (sequence[i]<=root){
                return false;
            }
        }
        return true;
    }
}