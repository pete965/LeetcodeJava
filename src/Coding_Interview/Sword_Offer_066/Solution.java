package Coding_Interview.Sword_Offer_066;
/*
地上有一个m行和n列的方格。
一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
请问该机器人能够达到多少个格子？
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.movingCount(15,100,1));

    }
    public int movingCount(int threshold, int rows, int cols)
    {
        int count=0;
        if (rows<=0||cols<=0||threshold<=0){
            return 0;
        }
        boolean[] booleans=new boolean[rows*cols];
        booleans[0]=true;
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{0,0});
        while (!stack.isEmpty()){
            int[] pop=stack.pop();
            System.out.println("x:"+pop[0]+"y:"+pop[1]);
            ArrayList<int[]> successors=getSuccessors(pop,booleans,rows,cols);
            for(int[] loc:successors){
                int row=loc[0];
                int col=loc[1];
                if (trueDigitalSum(row,col,threshold)){
                    stack.push(loc);
                }
            }
            count++;
        }
        return count;
    }

    private boolean trueDigitalSum(int row, int col, int threshold) {
        String rowString = String.valueOf(row);
        String colString = String.valueOf(col);
        int rowDigit=rowString.length();
        int colDigit=colString.length();
        int rowSum=0;
        int colSum=0;
        for (int j=0;j<rowDigit;j++){
            rowSum+=(rowString.charAt(j)-48);
        }
        for (int j=0;j<colDigit;j++){
            colSum+=(colString.charAt(j)-48);
        }
        return rowSum+colSum<=threshold;
    }

    private ArrayList<int[]> getSuccessors(int[] pop, boolean[] booleans,int rows,int cols) {
        int row=pop[0];
        int col=pop[1];
        ArrayList<int[]> outputArrayList=new ArrayList<>();
        int[] left=new int[]{row,col-1};
        int leftIndex=row*cols+col-1;
        int[] right=new int[]{row,col+1};
        int rightIndex=row*cols+col+1;
        int[] top=new int[]{row+1,col};
        int topIndex=(row+1)*cols+col;
        int[] below=new int[]{row-1,col};
        int belowIndex=(row-1)*cols+col;
        if (row-1>=0&&!booleans[belowIndex]){
            outputArrayList.add(below);
            booleans[belowIndex]=true;
        }
        if (col-1>=0&&!booleans[leftIndex]){
            outputArrayList.add(left);
            booleans[leftIndex]=true;
        }
        if (col+1<cols&&!booleans[rightIndex]){
            outputArrayList.add(right);
            booleans[rightIndex]=true;
        }
        if (row+1<rows&&!booleans[topIndex]){
            outputArrayList.add(top);
            booleans[topIndex]=true;
        }
        return outputArrayList;
    }
}