package climbingstairs;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] steps = {1,2};
        for(int i=1; i<=n;i++){
            for(int step : steps){
                if(i >= step) {
                    dp[i] += dp[i - step];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(8));
    }
}