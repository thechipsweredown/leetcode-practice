package onesandzeros;

import java.util.*;

class Solution {
    public boolean isEqual(String str1, HashMap<Integer,Long> map){
        long str01 = str1.chars().filter(ch -> ch == '0').count();
        long str11 = str1.chars().filter(ch -> ch == '1').count();
        if(str01 == 0 && str11 <= map.get(1)){
            map.put(1, map.get(1)-str11);
            return true;
        }else if(str11 == 0 && str01 <= map.get(0)){
            map.put(0, map.get(0)-str01);
            return true;
        }else{
            if(str01 <= map.get(0) && str11 <= map.get(1)){
                map.put(1, map.get(1)-str11);
                map.put(0, map.get(0)-str01);
                return true;
            }else return false;
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strs));
        int totalmax = 0;
        int p = Math.min(m, n);
        HashMap<Integer,Long> cost = new HashMap<>();
        cost.put(1,0L);
        cost.put(0,0L);

        for(int i=1; i<= p+1; i++){
            if(i != p+1){
                cost.put(1, cost.get(1)+1L);
                cost.put(0, cost.get(0)+1L);
            }
            if(i == p+1 && m==n) break;

            HashMap<Integer,ArrayList<String>> mapTmp = new HashMap<>();
            ArrayList<String> visit = new ArrayList<>();

            int max = 0;

            boolean isborrow = false;

            for(int k = 0; k < list.size(); k++){
                String s = list.get(k);
                if(isEqual(s,cost)){
                    max++;
                    visit.add(s);
                }
                if((cost.get(1) == 0L && cost.get(0) == 0L) || (k == list.size() - 1 && visit.size() > 0)){
                    if(k != list.size() - 1){
                        cost.put(1, cost.get(1) + 1L);
                        cost.put(0, cost.get(0) + 1L);
                        isborrow = true;
                    }
                    mapTmp.put(max,visit);
                    max = 0;
                    visit = new ArrayList<>();
                }
            }

            if(isborrow){
                if(cost.get(1) > 0) cost.put(1, cost.get(1)-1L);
                if(cost.get(0) > 0) cost.put(0, cost.get(0)-1L);
            }

            if(mapTmp.size() > 0){
                int maxp = Collections.max(mapTmp.keySet());
                for(String s : mapTmp.get(maxp)) list.remove(list.indexOf(s));
                totalmax += maxp;
            }

            if(i == p){
                if(m > n) cost.put(0, m-n + cost.get(0));
                else cost.put(1, n-m + cost.get(1));
            }
        }

        return totalmax;
    }

    public static void main(String[] args) {
        String[] array = {"111","1000","1000","1000"};
        System.out.println(new Solution().findMaxForm(array,9,3));
    }
}