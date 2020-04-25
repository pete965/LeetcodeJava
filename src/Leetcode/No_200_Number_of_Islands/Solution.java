package Leetcode.No_200_Number_of_Islands;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return 0;
        }else if (grid[0].length==0){
            return 0;
        }
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                    clear(i,j,grid);
                }
            }
        }
        return 0;
    }

    private void clear(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        if (i-1>=0&&grid[i-1][j]=='1'){
            clear(i-1,j,grid);
        }
        if (i+1<grid.length&&grid[i+1][j]=='1'){
            clear(i+1,j,grid);
        }
        if (j-1>=0&&grid[i][j-1]=='1'){
            clear(i,j-1,grid);
        }
        if (j+1<grid[0].length&&grid[i][j+1]=='1'){
            clear(i,j+1,grid);
        }
    }
}
