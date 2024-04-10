/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fc = 0;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                if(grid[i][j] == 1)
                    fc++;
            }
        }
        if(fc == 0)
            return 0;
        if(q.isEmpty())
            return -1;

        int[][] helper = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int time = -1;
        while(!q.isEmpty()){
            time++;
            int s = q.size();
            while(s-- > 0){
                int[] t = q.poll();
                for(int i=0; i<4; i++){
                    int[] h = helper[i];
                    int r = t[0]+h[0];
                    int c = t[1]+h[1];
                    if(r > -1 && c > -1 && r < m && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fc--;
                    }
                }
            }
        }
        return fc == 0 ? time : -1;
    }
}
