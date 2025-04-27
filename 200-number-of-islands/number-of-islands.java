import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] isVisited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int count = 0;


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && isVisited[i][j] == 0){
                    Pair p = new Pair(i, j);
                    queue.add(p);
                    isVisited[i][j] = 1;
                    count++;
                    bfs(grid, isVisited, n, m, queue);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int[][] isVisited, int n, int m, Queue<Pair> queue){
       while(!queue.isEmpty()){
            Pair p = queue.poll();
            int[][] helper = {{-1,0}, {0,-1}, {1,0},{0,1}};
            for(int t=0; t<4; t++){
                int i = p.x + helper[t][0];
                int j = p.y + helper[t][1];
                if(i<n && j<m && i >-1 && j> -1 && grid[i][j] == '1' 
                                                && isVisited[i][j] == 0){
                    isVisited[i][j] = 1;
                    queue.add(new Pair(i,j));
                }
            }
       }
    }
}

class Pair {
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}