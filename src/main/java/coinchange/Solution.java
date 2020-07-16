package coinchange;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        List<Integer> listcoins = Arrays.stream(coins).boxed().collect(Collectors.toList());
        for(int i=1; i <= amount;i++){
            boolean found = false;
            if(i < Collections.min(listcoins)) dp[i] = -1;
            else{
                for(int coin : coins) {
                    if (i >= coin && dp[i - coin] != -1) {
                        if (dp[i] == 0) dp[i] = dp[i - coin] + 1;
                        else dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        found = true;
                    }
                }
                if(!found) dp[i] = -1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {357,239,73,52};
        System.out.println(new Solution().coinChange(coins,9832));
    }
}
