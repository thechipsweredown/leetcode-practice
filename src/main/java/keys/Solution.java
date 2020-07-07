package keys;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.lang.StrictMath.sqrt;

class Solution {
    public ArrayList<Integer> getDivisor(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if(!list.contains(n/i) && i != 1) list.add(n/i);
            }
        }
        return list;
    }

    public int minSteps(int n) {
        if(n == 1) return 0;
        int[] min = new int[n+1];
        HashMap<Pair<Integer,Integer>, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            if(i==1){
                min[i] = 1;
                map.put(new Pair<>(1,1),1);
            }
            else{
                List<Integer> list = new ArrayList<>();
                ArrayList<Integer> divisor = getDivisor(i);
                for(Integer d : divisor){
                    if(map.containsKey(new Pair<>(i-d,d))){
                        int tmpMin = map.get(new Pair<>(i-d,d)) + 1;
                        list.add(tmpMin);
                        map.put(new Pair<>(i,d), tmpMin);
                    }else break;
                }
                min[i] = Collections.min(list);
                map.put(new Pair<>(i,i), min[i]+1);
            }
        }
        return min[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSteps(9));
    }
}
