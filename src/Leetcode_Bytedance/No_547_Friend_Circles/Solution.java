package Leetcode_Bytedance.No_547_Friend_Circles;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int[][] nums1 = new int[][]{{1,1,0},{1,1,1},{0,1,1}};
        int[][] nums2 = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int[][] nums3 = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution.findCircleNum(nums));
        System.out.println(solution.findCircleNum(nums1));
        System.out.println(solution.findCircleNum(nums2));
        System.out.println(solution.findCircleNum(nums3));
    }
    int count;
    public int findCircleNum(int[][] M) {
        count = 0;
        int n = M.length;
        int[] visited = new int[n];
        for (int i=0;i<n;i++){
            if (visited[i]==1){
                continue;
            }else {
                count++;
                visited[i]=1;
                dfs(i,M,visited);
            }
        }
        return count;
    }

    private void dfs(int i, int[][] m, int[] visited) {
        for (int j=0;j<m.length;j++){
            if (i==j||visited[j]==1||m[i][j]==0){
                continue;
            }else {
                visited[j]=1;
                dfs(j,m,visited);
            }
        }
    }
}
