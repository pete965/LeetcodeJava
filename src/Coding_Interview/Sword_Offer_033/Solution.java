package Coding_Interview.Sword_Offer_033;

/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index ==0){
            return 0;
        }
        int[] output = new int[index];
        output[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i=1;i<index;i++){
            output[i] = Math.min(output[p2]*2,Math.min(output[p3]*3,output[p5]*5));
            if (output[i]==output[p2]*2){p2++;}
            if (output[i]==output[p3]*3){p3++;}
            if (output[i]==output[p5]*5){p5++;}
        }
        return output[index-1];
    }
}
