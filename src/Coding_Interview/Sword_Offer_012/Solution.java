package Coding_Interview.Sword_Offer_012;

/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0
 */
public class Solution {
    public double Power(double base, int exponent) {
        if (base==0){
            return 0.0;
        }
        if (exponent==0){
            return 1.0;
        }

        double output=1.0;
        for (int i=0;i<Math.abs(exponent);i++){
            output*=base;
        }
        if (exponent<0){
            output=1/output;
        }
        return output;
    }
}