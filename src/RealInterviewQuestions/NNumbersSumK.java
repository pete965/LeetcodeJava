package RealInterviewQuestions;
//n integer numbers, sum is k(k>n). How many possibilities? Or list all the possibilities

import java.util.ArrayList;
import java.util.LinkedList;

public class NNumbersSumK {

     public static void main(String[] args){
         LinkedList<ArrayList<Integer>> output = new LinkedList<>();
         ArrayList<Integer> single = new ArrayList<>();
         NNumbersSumK nNumbersSumK = new NNumbersSumK();
         nNumbersSumK.allPossibilities(output,single,3,5);
         for (ArrayList arrayList : output) {
             System.out.println(arrayList.toString());
         }
     }
     public void allPossibilities(LinkedList<ArrayList<Integer>> output, ArrayList<Integer> single, int n,int k){
         if (n == 1) {
             single.add(k);
             output.add(new ArrayList<Integer>(single));
             single.remove(single.size()-1);
         } else {
             for (int i = 1;i <= k-n+1; i++){
                 single.add(i);
                 allPossibilities(output, single,n-1,k-i);
                 single.remove(single.size()-1);
            }
         }
    }
}
