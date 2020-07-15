package maximumsquares;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int matchPair(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2){
        int p1y = (p1.getKey() + p1.getValue() - 1);
        int p1x = p1.getKey();

        int p2y = (p1.getKey() + p1.getValue() - 1);
        int p2x = p1.getKey();

        int max;

        if(p1x >= p2x && p1y <= p2y){
            max = p1.getValue();
        }else if(p2x >= p1x && p2y <= p1y){
            max = p2.getValue();
        }else if(p1y < p2y){
            max = p1y - p2x + 1;
        }else{
            max = p2y - p1x + 1;
        }

        return max;
    }
    public int maximalSquare(char[][] matrix) {
        HashMap<Integer, ArrayList<Pair<Integer,Integer>>> map = new HashMap<>();
        int[] max = new int[matrix.length+1];
        for(int i=0; i< matrix.length;i++){
            int l = 0;
            for(int j=0; j<matrix[i].length;j++){
                if((i == 0 || !map.containsKey(i - 1)) && matrix[i][j] == '1'){
                    max[i+1] = 1;
                }
                if(matrix[i][j] == '1'){
                    l++;
                }
                if((j == matrix[i].length - 1  || matrix[i][j+1] == '0') && l != 0){
                    if(map.containsKey(i+1)){
                        map.get(i+1).add(new Pair<>(j-l+1,l));
                    }else{
                        ArrayList<Pair<Integer,Integer>> list = new ArrayList<>();
                        list.add(new Pair<>(j-l+1,l));
                        map.put(i+1,list);
                    }
                    l = 0;
                }
            }
            if(i > 0){
                if(!map.containsKey(i+1)){
                    max[i] = 0;
                }else{{

                }}
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] m = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Solution().maximalSquare(m));
    }
}