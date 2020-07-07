package maxsubarray;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int maxSubArray(int[] arr){
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        HashMap<Integer, Integer> mapSk = new HashMap<>();
        HashMap<Integer, Integer> mapEk = new HashMap<>();
        for(int i = 1; i <= list.size(); i++){
            if(i == 1){
                mapSk.put(i, list.get(i-1));
                mapEk.put(i, list.get(i-1));
            }else{
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(list.get(i-1));
                tmpList.add(mapEk.get(i-1) + list.get(i-1));
                tmpList.add(mapSk.get(i-1));
                mapSk.put(i, Collections.max(tmpList));
                mapEk.put(i, Math.max(list.get(i-1),list.get(i-1) + mapEk.get(i-1)));
            }
        }
        return mapSk.get(arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(new Solution().maxSubArray(arr));
    }
}
