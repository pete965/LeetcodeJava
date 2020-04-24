package RealInterviewQuestions;

import java.util.ArrayList;
import java.util.LinkedList;

public class NNumberSumKDynamicProgramming {
    public static void main(String[] args){
        NNumberSumKDynamicProgramming nNumberSumKDynamicProgramming = new NNumberSumKDynamicProgramming();
        int n=3;
        int k=6;
        Combination[][] dp = new Combination[n][k];
        nNumberSumKDynamicProgramming.allPossibilities(dp,n,k);
    }
    public void allPossibilities(Combination[][] dp, int n, int k){
        for (int i=0;i<n;i++){
            for (int j=i;j<k;j++){
                dp[i][j] = new Combination(new LinkedList<LinkedList<Integer>>());
//                System.out.println("dp[0][0] is:"+dp[0][0].toString());
                for (int m=1;m<=j-i+1;m++){
                    if (i>0){
                        Combination combination;
                        combination = new Combination(dp[i-1][j-m]);
                        combination.append(m);
                        dp[i][j].combine(combination);
                    }else {
                        LinkedList<Integer> list = new LinkedList<>();
                        list.add(j+1);
                        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
                        lists.add(list);
                        dp[i][j].combine(new Combination(lists));
                    }
                }
            }
        }
        for (LinkedList<Integer> list:dp[n-1][k-1].getLists()){
            System.out.println(list.toString());
        }
    }

    private Combination calDP(Combination[][] dp, int n, int k) {
        Combination combination = new Combination(new LinkedList<LinkedList<Integer>>());
        for (int i=1;i<k-n+1;i++){
            if (n>0){
                Combination newComb;
                if (dp[n-1][k-i].isEmpty()){
                    newComb=calDP(dp,n-1,k-i);
                }else {
                    newComb=dp[n-1][k-i];
                }
                newComb.append(i);
                combination.combine(newComb);
            }else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(k);
                LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
                lists.add(list);
                combination.combine(new Combination(lists));
            }
        }
        return combination;
    }

    class Combination{
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
        public Combination(LinkedList<LinkedList<Integer>> lists){
            this.lists = lists;
        }
        public Combination(Combination combination){
            for (LinkedList<Integer> list:combination.getLists()){
                this.lists.add(new LinkedList<Integer>(list));
            }
        }
        public void append(int n){
            for (LinkedList<Integer> list:lists){
                list.addFirst(n);
            }
        }
        public void combine(Combination combination){
            for (LinkedList<Integer> list:combination.getLists()){
                if (!lists.contains(list)){
                    lists.add(list);
                }
            }
        }
        public LinkedList<LinkedList<Integer>> getLists() {
            return lists;
        }
        public boolean isEmpty(){
            if (lists.size()==0){
                return true;
            }else {
                return false;
            }
        }
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            for (LinkedList<Integer> list:lists){
                stringBuilder.append(list.toString()+"\n");
            }
            if (stringBuilder.length()!=0){
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
            return stringBuilder.toString();
        }
    }
}
