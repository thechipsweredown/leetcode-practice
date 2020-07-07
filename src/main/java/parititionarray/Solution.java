package parititionarray;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        HashMap<Integer, Integer> mapMax = new HashMap<>();
        for(int i = 0; i < list.size();i++){
            List<Integer> subList = list.subList(0, i+1);
            if((i+1) <= K){
                mapMax.put(i+1, Collections.max(subList)* subList.size());
            }else{
                int tmp = K;
                List<Integer> tmpList = new ArrayList<>();
                while(tmp != 0){
                    List<Integer> tmpSubList = list.subList(i-tmp+1, i+1);
                    tmpList.add(Collections.max(tmpSubList)*tmp + mapMax.get((i+1) - tmp));
                    tmp--;
                }
                mapMax.put(i+1, Collections.max(tmpList));
            }
        }
        return mapMax.get(A.length);
    }

    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        System.out.println(new Solution().maxSumAfterPartitioning(arr, 3));

    }
}
