package maxproductsubarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int maxProduct(int[] nums) {
        HashMap<Integer,Integer> mapMax = new HashMap<>();
        HashMap<Integer,Integer> mapPos = new HashMap<>();
        HashMap<Integer,Integer> mapNeg= new HashMap<>();
        for(int i=0; i < nums.length;i++){
            if(i == 0){
                mapMax.put(i,nums[i]);
                if(nums[i] < 0){
                    mapNeg.put(i, nums[i]);
                }
                else{
                    mapPos.put(i, nums[i]);
                }
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                int n = nums[i];
                tmp.add(n);
                tmp.add(mapMax.get(i-1));

                Integer neg = mapNeg.getOrDefault(i-1,null);
                Integer pos = mapPos.getOrDefault(i-1,null);

                if(neg != null) tmp.add(n*neg);
                if(pos != null) tmp.add(n*pos);

                if(n < 0){
                    if(pos != null)  mapNeg.put(i, Math.min(n*pos,n));
                    else mapNeg.put(i, n);
                    if(neg != null) mapPos.put(i, Math.max(n*neg,n));
                }else{
                    if(pos != null)  mapPos.put(i, Math.max(n*pos,n));
                    else mapPos.put(i,n);
                    if(neg != null) mapNeg.put(i, Math.min(n*neg,n));
                }
                mapMax.put(i, Collections.max(tmp));
            }
        }
        return mapMax.get(nums.length-1);
    }
}