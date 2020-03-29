package Coding_Interview.Sword_Offer_032;

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int length = numbers.length;
        if (length == 0){
            return "";
        }
        if (length == 1){
            return String.valueOf(numbers[0]);
        }
        for (int i=(length-2)/2;i>=0;i--){
            if (isSmaller(numbers[2*i+1],numbers[i])||isSmaller(numbers[2*i+2],numbers[i])){
                if (isSmaller(numbers[2*i+1],numbers[2*i+2])){
                    swap(2*i+1,i,numbers);
                }else{
                    swap(2*i+2,i,numbers);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<length;i++){
            stringBuilder.append(numbers[i]);
        }
        return stringBuilder.toString();
    }

    private void swap(int i, int i1, int[] numbers) {
        int mid = numbers[i];
        numbers[i] = numbers[i1];
        numbers[i1] = mid;
    }

    private boolean isSmaller(int number, int number1) {
        int first = Integer.valueOf(number+""+number1);
        int second = Integer.valueOf(number1+""+number);
        if (first<second){
            return true;
        }else{
            return false;
        }
    }
}
