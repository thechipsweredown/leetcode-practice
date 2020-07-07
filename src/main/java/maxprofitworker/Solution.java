package maxprofitworker;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        for (int i = 0; i < difficulty.length; i++) {
            for (int j = 0; j < difficulty.length -1 - i; j++) {
                if (difficulty[j] - difficulty[j+1] > 0) {
                    int swapd = difficulty[j];
                    difficulty[j] = difficulty[j + 1];
                    difficulty[j + 1] = swapd;

                    int swapp = profit[j];
                    profit[j] = profit[j + 1];
                    profit[j + 1] = swapp;
                }
            }
        }
        int sum = 0;

        for (int value : worker) {
            int maxp = 0;
            for (int j = 0; j < difficulty.length; j++) {
                if (difficulty[j] > value) break;
                if (profit[j] >= maxp)
                    maxp = profit[j];
            }
            sum += maxp;
        }
        return sum;
    }
}
