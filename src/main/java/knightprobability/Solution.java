package knightprobability;

import javafx.util.Pair;

import java.util.HashMap;

class Solution {
    public void findmoves(int n, int x, int y, HashMap<Pair<Integer,Integer>,Double> map,HashMap<Pair<Integer,Integer>,Double> old){
        Double o = old.get(new Pair<>(x,y));
        if(x-1 >= 0 && x-1 < n && y+2 >= 0 && y+2 < n){
            if(map.containsKey(new Pair<>(x-1,y+2))) map.put(new Pair<>(x-1,y+2), (map.get(new Pair<>(x-1,y+2)) + o));
            else map.put(new Pair<>(x-1,y+2),o);
        }
        if(x-1 >= 0 && x-1 < n && y-2 >= 0 && y-2 < n){
            if(map.containsKey(new Pair<>(x-1,y-2))) map.put(new Pair<>(x-1,y-2), map.get(new Pair<>(x-1,y-2)) + o);
            else map.put(new Pair<>(x-1,y-2),o);
        }
        if(x+1 >= 0 && x+1 < n && y+2 >= 0 && y+2 < n){
            if(map.containsKey(new Pair<>(x+1,y+2))) map.put(new Pair<>(x+1,y+2), map.get(new Pair<>(x+1,y+2)) + o);
            else map.put(new Pair<>(x+1,y+2),o);
        }
        if(x+1 >= 0 && x+1 < n && y-2 >= 0 && y-2 < n){
            if(map.containsKey(new Pair<>(x+1,y-2))) map.put(new Pair<>(x+1,y-2), map.get(new Pair<>(x+1,y-2)) + o);
            else map.put(new Pair<>(x+1,y-2),o);
        }
        if(x-2 >= 0 && x-2 < n && y+1 >= 0 && y+1 < n){
            if(map.containsKey(new Pair<>(x-2,y+1))) map.put(new Pair<>(x-2,y+1), map.get(new Pair<>(x-2,y+1)) + o);
            else map.put(new Pair<>(x-2,y+1),o);
        }
        if(x-2 >= 0 && x-2 < n && y-1 >= 0 && y-1 < n){
            if(map.containsKey(new Pair<>(x-2,y-1))) map.put(new Pair<>(x-2,y-1), map.get(new Pair<>(x-2,y-1)) + o);
            else map.put(new Pair<>(x-2,y-1),o);
        }
        if(x+2 >= 0 && x+2 < n && y+1 >= 0 && y+1 < n){
            if(map.containsKey(new Pair<>(x+2,y+1))) map.put(new Pair<>(x+2,y+1), map.get(new Pair<>(x+2,y+1)) + o);
            else map.put(new Pair<>(x+2,y+1),o);
        }
        if(x+2 >= 0 && x+2 < n && y-1 >= 0 && y-1 < n){
            if(map.containsKey(new Pair<>(x+2,y-1))) map.put(new Pair<>(x+2,y-1), map.get(new Pair<>(x+2,y-1)) + o);
            else map.put(new Pair<>(x+2,y-1),o);
        }
    }
    public double knightProbability(int N, int K, int r, int c) {
        if(r >= N || c >= N || r<0 || c < 0) return 0;
        HashMap<Integer, HashMap<Pair<Integer,Integer>,Double>> map = new HashMap<>();
        HashMap<Pair<Integer,Integer>,Double> map1 = new HashMap<>();
        map1.put(new Pair<>(c, r), 1.0);
        map.put(0,map1);

        for(int i=1;i<=K;i++){
            HashMap<Pair<Integer,Integer>,Double> map2 = new HashMap<>();
            for (Pair<Integer,Integer> p : map.get(i-1).keySet()){
                findmoves(N,p.getKey(),p.getValue(), map2,map.get(i-1));
            }
            map2.replaceAll((k, v) -> v * 0.125);
            map.put(i, map2);
        }
        double v = 0;
        HashMap<Pair<Integer,Integer>,Double> mapK = map.get(K);
        for(Pair<Integer,Integer> k : mapK.keySet()){
            v += mapK.get(k);
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().knightProbability(8,30,6,4));
    }
}