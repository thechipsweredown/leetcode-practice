package perfectSquare;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.StrictMath.sqrt;

class Solution {
    public ArrayList<Integer> getSq(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= sqrt(n); i++){
            list.add(i*i);
        }
        return list;
    }
    public int numSquares(int n) {
        int[] min = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(i==1){
                min[i] = 1;
            }else{
                ArrayList<Integer> tmp = getSq(i);
                ArrayList<Integer> list = new ArrayList<>();
                for(Integer s : tmp){
                    list.add(min[i-s] + 1);
                }
                min[i] = Collections.min(list);
            }
        }
        return min[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}