package productdistribution;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    
    /*
     * Complete the 'maxScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER m
     */
    
    public static int maxScore(List<Integer> a, int m) {
        // Write your code here
        if(a.size() <= m){
            double d = 0;
            for (Integer integer : a) {
                d += integer;
                d = d % (Math.pow(10, 9) + 7);
            }
            return (int)d;
        }else if(m == 1){
            double d = 0;
            int tm = 1;
            Collections.sort(a);
            for (Integer integer : a) {
                d += (integer % (Math.pow(10, 9) + 7)) * tm;
                d = d % (Math.pow(10, 9) + 7);
                tm++;
            }
            return (int)d;
        }else{
            double d = 0;
            int cnt = 0;
            int tm = 1;
            int last_index = a.size()/m;
            Collections.sort(a);
            for(int i=0; i<a.size();i++){
                d += a.get(i)*tm;
                cnt++;
                if(cnt == m){
                    cnt = 0;
                    if(tm == last_index-1){
                        for(int j=i+1;j<a.size();j++){
                            d += (tm+1)*a.get(j);
                        }
                        d = d % (Math.pow(10,9)+7);
                        return (int)d;
                    }
                    tm++;
                }
            }
            d = d % (Math.pow(10,9)+7);
            return (int)d;
        }
        
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/input10.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("conf/out.txt"));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(firstMultipleInput[0]);
        
        int m = Integer.parseInt(firstMultipleInput[1]);
        
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                              .map(Integer::parseInt)
                              .collect(toList());
        
        int ans = Result.maxScore(a, m);
        
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}