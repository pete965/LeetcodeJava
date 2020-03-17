package Coding_Interview.Sword_Offer_065;
/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        if (solution.hasPath(new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'},3,4,new char[]{'A','B','C','C','E','D'})){
            System.out.println("Yes");
        }
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] booleans =new boolean[matrix.length];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(judge(matrix,i,j,rows,cols,booleans,str,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean judge(char[] matrix,int i,int j,int rows, int cols,boolean[] booleans,char[] str,int k) {
        int index=i*cols+j;
        if (i<0||j<0||i>=rows||j>=cols||str[k]!=matrix[index]||booleans[index]==true){
            return false;
        }
        if (k==str.length-1){
            return true;
        }
        booleans[index]=true;
        if (judge(matrix,i+1,j,rows,cols,booleans,str,k+1)
                ||judge(matrix,i-1,j,rows,cols,booleans,str,k+1)
                ||judge(matrix,i,j+1,rows,cols,booleans,str,k+1)
                ||judge(matrix,i,j-1,rows,cols,booleans,str,k+1))
        {
            return true;
        }
        booleans[index]=false;
        return false;
    }
}