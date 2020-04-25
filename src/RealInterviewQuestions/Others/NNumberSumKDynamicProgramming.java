package RealInterviewQuestions.Others;

import java.util.LinkedList;

public class NNumberSumKDynamicProgramming {
    public static void main(String[] args){
        NNumberSumKDynamicProgramming nNumberSumKDynamicProgramming = new NNumberSumKDynamicProgramming();
        //n个数
        int n=3;
        //和为k
        int k=6;
        //初始化动态规划对象数组
        Combination[][] dp = new Combination[n][k];
        System.out.println(n+" numbers, their sum is "+ k +", all possibilities:");
        nNumberSumKDynamicProgramming.allPossibilities(dp,n,k);
    }
    public void allPossibilities(Combination[][] dp, int n, int k){
        for (int i=0;i<n;i++){
            for (int j=i;j<k;j++){
                //将动态规划数组的单元格初始化，防止空指针异常
                dp[i][j] = new Combination(new LinkedList<LinkedList<Integer>>());
                //尝试第一个数的所有可能
                for (int m=1;m<=j-i+1;m++){
                    //如果i>0，那么动态规划数组的值dp[i][j]，会依赖与dp[i-1][j-m]的值
                    if (i>0){
                        Combination combination;
                        combination = new Combination(dp[i-1][j-m]);
                        //将第一个数附到dp[i-1][j-m]的值的每个组合的起始位置，令其组合的长度增加1
                        combination.append(m);
                        dp[i][j].combine(combination);
                    }else {
                        //如果i=0，那么说明我们正在处理“1个数，和为n”的问题
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

    /*
    n个数和为k的数字组合封装类
     */
    class Combination{
        //存储数字组合
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
        //构建方法1，用于基于组合链表的构建
        public Combination(LinkedList<LinkedList<Integer>> lists){
            this.lists = lists;
        }
        //构建方法2，用于基于原有的Combination对象，建立一个内容一样的新对象
        public Combination(Combination combination){
            for (LinkedList<Integer> list:combination.getLists()){
                this.lists.add(new LinkedList<Integer>(list));
            }
        }
        //append方法，用于将n-1个数和为k的组合向n个数和为j转化
        public void append(int n){
            for (LinkedList<Integer> list:lists){
                list.addFirst(n);
            }
        }
        //combine方法，用于将若干n个数的组合合并到一起
        public void combine(Combination combination){
            for (LinkedList<Integer> list:combination.getLists()){
                if (!lists.contains(list)){
                    lists.add(list);
                }
            }
        }
        //getter方法
        public LinkedList<LinkedList<Integer>> getLists() {
            return lists;
        }
        //isEmpty方法
        public boolean isEmpty(){
            if (lists.size()==0){
                return true;
            }else {
                return false;
            }
        }
        //toString方法
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
