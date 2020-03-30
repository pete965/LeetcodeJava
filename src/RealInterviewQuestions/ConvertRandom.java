package RealInterviewQuestions;

import java.util.Arrays;

public class ConvertRandom {
    public static void main(String[] args) {
        ConvertRandom convertRandom = new ConvertRandom();
        double[] count = new double[11];
        int max = 100000000;
        for (int i=0;i<=max;i++){
            int result = (int)(convertRandom.random7());
            count[result]++;
        }
        for (int i=0;i<11;i++){
            count[i]/=max;
        }
        System.out.println(Arrays.toString(count));
    }
    public double random9(){
        return (Math.random()*8)+1;
    }
    public double random7(){
        double res = random9();
        if (res>=7){
            return random7();
        }else{
            return res;
        }
    }
    public double newrandom7(){
        double res = random9();
        res-=1;
        res/=8;
        res*=6;
        res+=1;
        return res;
    }
}
