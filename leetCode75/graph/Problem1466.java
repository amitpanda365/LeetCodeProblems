/*
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.
Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

*/

import java.util.*;

class Solution {
    private int count = 0;
    public int minReorder(int n, int[][] c) {
        List[] g = new List[n];
        int[] isVisited = new int[n];
        for(int i=0; i<n; i++){
            g[i] = new ArrayList<Integer>();
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<n-1; i++){
            g[c[i][0]].add(c[i][1]);
            g[c[i][1]].add(c[i][0]);
            if(map.get(c[i][0]) == null){
                Set<Integer> s = new HashSet<>();
                s.add(c[i][1]);
                map.put(c[i][0], s);
            }
            else{
                Set s = map.get(c[i][0]);
                s.add(c[i][1]);
            }
        }

        System.out.println(map);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            Integer t = q.poll();
            System.out.println(t + " "+ g[t]);
            List tl = g[t];
            if(isVisited[t] == 0){
                isVisited[t] = 1;
                tl.forEach(x -> {
                if(isVisited[(int)x] == 0){
                    q.add((int)x);
                    if(map.get(t) != null && (map.get(t)).contains(x))
                        count++;
                }
                });
            }
        }
        return count;
    }
}
