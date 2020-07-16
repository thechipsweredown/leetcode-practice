package miniumfallingpath;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    public int minFallingPathSum(int[][] A) {
        int[][] state = A;
        int min = 0;
        for(int i = 1; i < A.length;i++){
            for(int j = 0 ; j < A[i].length;j++){
                if(j == 0) state[i][j] = A[i][j] + Math.min(state[i-1][j], state[i-1][j+1]);
                else if(j > 0 && j < A[i].length-1) state[i][j] = A[i][j] + min(state[i-1][j-1], state[i-1][j], state[i-1][j+1]);
                else state[i][j] = A[i][j] + Math.min(state[i-1][j], state[i-1][j-1]);
            }
        }
        int[] tmp = state[state.length-1];
        List<Integer> list = Arrays.stream(tmp)
                .boxed()
                .collect(Collectors.toList());
        return Collections.min(list);
    }
}