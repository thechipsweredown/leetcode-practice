package targetsum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        List<Integer> n = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if(nums.length == 1){
            if(Math.abs(nums[0]) == Math.abs(S)) return 1;
            else return 0;
        }
        int sum = IntStream.of(nums).sum();
        int psum = (sum + S)/2;

        if(Math.floor(psum) != psum) return 0;
        
        int[] dp = new int[psum+1];
        int[] c = new int[psum+1];

        for(int i=1; i<=psum;i++){
            boolean found = false;
            for(int coin : new HashSet<>(n)){
                if (i >= coin && dp[i - coin] != -1) {
                    c[i] = c[i]++;
                    if (dp[i] == 0){
                        dp[i] = dp[i - coin] + 1;
                        c[i] = 1;
                    }else{
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        c[i] = c[i] + 1;
                    }
                    found = true;
                }
            }
            if(!found) dp[i] = -1;
        }
        System.out.println(Arrays.stream(dp).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(c).boxed().collect(Collectors.toList()));

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {9,7,3,9,8,6,5,7,6};
        System.out.println(new Solution().findTargetSumWays(arr, 2));
    }
}
