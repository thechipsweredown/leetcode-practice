package laststoneweight;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        Boolean [] dp = new Boolean[sum+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        for(int w : stones){
            for(int i = sum; i >= 0;i--){
                if(i - w < 0) break;
                if(dp[i - w]) dp[i] = true;
            }
        }
        int min = sum + 1;
        for(int i = 1; i <= sum;i++){
            if(dp[i] && 2*i - sum >= 0){
                min = Math.min(min, 2*i-sum);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [] array = {1,1,4,2,2};
        System.out.println(new Solution().lastStoneWeightII(array));
    }

}