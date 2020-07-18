package knightprobability;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Pair<Integer,Integer>> findmoves(int n, int x, int y){
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        if(x-1 >= 0 && x-1 < n-1 && y+2 >= 0 && y+2 < n) list.add(new Pair<>(x,y));
        if(x-1 >= 0 && x-1 < n-1 && y-2 >= 0 && y-2 < n) list.add(new Pair<>(x,y));
        if(x+1 >= 0 && x+1 < n-1 && y+2 >= 0 && y+2 < n) list.add(new Pair<>(x,y));
        if(x+1 >= 0 && x+1 < n-1 && y-2 >= 0 && y-2 < n) list.add(new Pair<>(x,y));
        if(x-2 >= 0 && x-2 < n-1 && y+1 >= 0 && y+1 < n) list.add(new Pair<>(x,y));
        if(x-2 >= 0 && x-2 < n-1 && y-1 >= 0 && y-1 < n) list.add(new Pair<>(x,y));
        if(x+2 >= 0 && x+2 < n-1 && y+1 >= 0 && y+1 < n) list.add(new Pair<>(x,y));
        if(x+2 >= 0 && x+2 < n-1 && y-1 >= 0 && y-1 < n) list.add(new Pair<>(x,y));
        return list;
    }
    public double knightProbability(int N, int K, int r, int c) {
        double[] dp = new double[K+1];
        dp[0] = 1;
        int x = c;
        int y = r;
        HashMap<Integer,ArrayList<Pair<Integer,Integer>>> map = new HashMap<>();
        map.put(1, findmoves(N,x,y));
        for(int i=1;i<=K;i++){
            for (Pair<Integer,Integer> p : map.get(i)){
                dp[i] += dp[i-1]*1.0/8;

            }
        }
        return dp[K];
    }
}