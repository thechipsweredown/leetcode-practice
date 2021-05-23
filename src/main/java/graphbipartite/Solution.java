package graphbipartite;

public class Solution {
    //https://leetcode.com/problems/is-graph-bipartite/submissions/
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] tag = new int[n]; //tag of node
        tag[0] = 1; // assign tag for first node

        for (int i = 0; i < n; i++) {
            for(int c : graph[i]){
                if(tag[c] == 0){
                    tag[c] = 3 - tag[i];
                }else if(tag[c] != 0 && tag[c] == tag[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(new Solution().isBipartite(graph));
    }
}
