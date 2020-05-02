package Leetcode_Bytedance.No_695_Max_Area_of_Island;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                                                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                                                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                                                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                                                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                                                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                                                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                                                 {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visit = new int[rows][cols];
        int count = 0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (visit[i][j]==1){
                    continue;
                }
                if (grid[i][j]==1){
                    visit[i][j] = 1;
                    count=Math.max(count,calArea(i,j,grid,visit));
                }
            }
        }
        return count;
    }

    private int calArea(int i, int j,int[][] grid,int[][] visit) {
        int output = 1;
        if (i-1>=0&&grid[i-1][j]==1&&visit[i-1][j]==0){
            visit[i-1][j] = 1;
            grid[i-1][j] = 0;
            output+=calArea(i-1,j,grid,visit);
        }
        if (i+1<grid.length&&grid[i+1][j]==1&&visit[i+1][j]==0){
            visit[i+1][j] = 1;
            grid[i+1][j] = 0;
            output+=calArea(i+1,j,grid,visit);
        }
        if (j-1>=0&&grid[i][j-1]==1&&visit[i][j-1]==0){
            visit[i][j-1] = 1;
            grid[i][j-1] = 0;
            output+=calArea(i,j-1,grid,visit);

        }
        if (j+1<grid[0].length&&grid[i][j+1]==1&&visit[i][j+1]==0){
            visit[i][j+1] = 1;
            grid[i][j+1] = 0;
            output+=calArea(i,j+1,grid,visit);
        }
        return output;
    }
}
