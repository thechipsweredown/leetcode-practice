package maximumsquares;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public int maximalSquare(char[][] matrix) {
        HashMap<Integer,ArrayList<Pair<Pair<Integer,Integer>,Integer>>> angle = new HashMap<>();
        int[] max = new int[matrix.length+1];
        for(int i = 0; i < matrix.length;i++){
            ArrayList<Pair<Pair<Integer,Integer>,Integer>> list = new ArrayList<>();
            for(int j = 0; j < matrix[i].length;j++){
                if(matrix[i][j] == '1'){
                    if(j < matrix[i].length - 1 && i < matrix.length - 1)  list.add(new Pair<>(new Pair<>(i,j),1));
                    max[i+1] = 1;
                }
                angle.put(i+1,list);
            }
            if(i>0){
                ArrayList<Pair<Pair<Integer,Integer>,Integer>> tmp = angle.get(i);
                ArrayList<Pair<Pair<Integer,Integer>,Integer>> lista = angle.containsKey(i+1)?angle.get(i+1): new ArrayList<>();
                ArrayList<Integer> tmpMax = new ArrayList<>();
                for(Pair<Pair<Integer,Integer>,Integer> pp : tmp){
                    Pair<Integer,Integer> p = pp.getKey();
                    int m = pp.getValue()+1;
                    int x = p.getKey() + 1;
                    int y = p.getValue() + 1;
                    boolean tmpUp = false;
                    if(matrix[x][y] == '1'){
                        tmpUp = true;
                        for(int k = m-1; k > 0; k--){
                            if(matrix[x][y-k] == '0' || matrix[x-k][y] == '0'){
                                tmpUp = false;
                                break;
                            }
                        }
                    }
                    if(tmpUp){
                        tmpMax.add(m);
                        if(y < matrix[i].length - 1 && x < matrix.length - 1)   lista.add(new Pair<>(new Pair<>(x,y),m));
                    }
                }
                tmpMax.add(0);
                max[i+1] = Math.max(max[i+1],Collections.max(tmpMax));
                angle.put(i+1,lista);
            }
        }
        int edge = Collections.max(Arrays.stream(max).boxed().collect(Collectors.toList()));
        return edge*edge;
    }

    public static void main(String[] args) {
        char[][] m = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Solution().maximalSquare(m));
    }
}