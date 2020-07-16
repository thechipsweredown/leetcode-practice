package maximumsquares;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int maximalSquare(char[][] matrix) {
        HashMap<Integer,ArrayList<Pair<Integer,Integer>>> angle = new HashMap<>();
        int[] max = new int[matrix.length+1];
        for(int i = 0; i < matrix.length;i++){
            ArrayList<Pair<Integer,Integer>> list = new ArrayList<>();
            boolean isUp = false;
            for(int j = 0; j < matrix[i].length;j++){
                if((i==0 || !angle.containsKey(i)) && matrix[i][j] == '1'){
                    isUp = true;
                    if(j < matrix[i].length - 1 || i < matrix.length - 1)  list.add(new Pair<>(i,j));
                    if(list.size() > 0) angle.put(i+1,list);
                }else{
                }
            }
            ArrayList<Pair<Integer,Integer>> tmp = angle.get(i);
            for(Pair<Integer,Integer> p : tmp){
                int x = p.getKey() + 1;
                int y = p.getValue() + 1;
                if(matrix[x][y] == '1'){
                    int m = max[i-1];
                    boolean tmpUp = true;
                    for(int k = m; k > 0; k--){
                        if(matrix[x][y-k] == '0' || matrix[x=k][y] == '0'){
                            tmpUp = false;
                            break;
                        }
                    }
                }
            }
            if(isUp) max[i+1] = max[i] + 1;
            else max[i+1] = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] m = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Solution().maximalSquare(m));
    }
}