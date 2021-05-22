package numberprovinces;

import java.util.*;

public class Solution {
    //https://leetcode.com/problems/number-of-provinces/submissions/
    public int findCircleNum(int[][] isConnected) {
        int numProvinces = 0;
        int n = isConnected.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++){
            graph.put(i, new HashSet<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    graph.get(i+1).add(j+1);
                }
            }
        }
        Set<Integer> traverses = new HashSet<>();
        for(int i = 1; i <= n; i++){
            if(!traverses.contains(i)){
                numProvinces++;
                Set<Integer> visited = new HashSet<>();
                visited.add(i);
                List<Integer> wait = new ArrayList<>(graph.get(i));
                while(wait.size() > 0){
                    int first = wait.get(0);
                    if(visited.contains(first)) wait.remove(0);
                    else{
                        visited.add(first);
                        Set<Integer> com = graph.get(first);
                        wait.addAll(com);
                    }
                }
                traverses.addAll(visited);
            }
        }
        return numProvinces;
    }

    public static void main(String[] args) {
        int[][] arr =  {{1,1,1,1,0,0,0,0},
                        {1,1,0,0,0,0,0,0},
                        {1,0,1,1,0,0,0,0},
                        {1,0,1,1,0,0,0,0},
                        {0,0,0,0,1,1,1,0},
                        {0,0,0,0,1,1,1,0},
                        {0,0,0,0,1,1,1,0},
                        {0,0,0,0,0,0,0,1}};
        System.out.println(new Solution().findCircleNum(arr));
    }
}
