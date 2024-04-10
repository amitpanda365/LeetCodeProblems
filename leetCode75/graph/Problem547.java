/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
*/

class Solution {

    public int findCircleNum(int[][] ic) {
        int n = ic.length;
        int[] visited = new int[n];
        int res = 0;
        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                res++;
                dfs(ic, i, visited);
            }
        }
        return res;
    }

    private void dfs(int[][] ic, int node, int[] visited){
        visited[node] = 1;
        for(int i=0; i<ic.length; i++){
            if(visited[i] == 0 && ic[node][i] == 1)
                dfs(ic, i, visited);
        }
    }
}
