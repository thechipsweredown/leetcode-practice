package miniumcosttickets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length-1];
        int[] min = new int[max+10];
        min[0] = 0;
        List<Integer> list = Arrays.stream(days).boxed().collect(Collectors.toList());
        for(int i=1; i<= max; i++){
            if(!list.contains(i)){
                min[i] = min[i-1];
            }else{
                if(i == 1){
                    min[i] = costs[0];
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    int m1 = min[i-1] + costs[0];
                    int m2 = 0;
                    int m3 = 0;
                    if(i > 7) m2 = min[i-7] + costs[1];
                    else m2 = costs[1];
                    if(i > 30) m3 = min[i-30] + costs[2];
                    else m3 = costs[2];
                    tmp.add(m1);
                    tmp.add(m2);
                    tmp.add(m3);
                    int mintmp = Collections.min(tmp);
                    min[i] = mintmp;
                }
            }
        }
        return min[max];
    }
}