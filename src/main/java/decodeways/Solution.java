package decodeways;

import java.util.Arrays;
import java.util.List;

public class Solution {
    Character[] c = new Character[]{ '1', '2','*'};
    List<Character> list = Arrays.asList(c);
    public int numDecodings(String s) {
        double[] w = new double[s.length()+1];
        w[0] = 1;
        for(int i=1; i<=s.length();i++){
            if(i==1){
                if(s.charAt(i-1) == '0') return 0;
                else if(s.charAt(i-1) == '*') w[i] = 9;
                else w[i] = 1;
            }else{
                if(s.charAt(i-1) == '0' && !list.contains(s.charAt(i-2))) return 0;
                else if(s.charAt(i-1) == '0'){
                    if(s.charAt(i-2) == '*') w[i] = (w[i-2]*2)%((Math.pow(10,9)+7));
                    else w[i] = w[i-2];
                }else if(s.charAt(i-1) == '*'){
                    if(s.charAt(i-2) == '*') w[i] = 15*w[i-2] + 9*w[i-1];
                    else if(s.charAt(i-2) == '1') w[i] = 9*(w[i-2] + w[i-1]);
                    else if(s.charAt(i-2) == '2') w[i] = 9*w[i-1] + 6*w[i-2];
                    else w[i] = 9*w[i-1];
                }else{
                    if(s.charAt(i-2) == '0') w[i] = w[i-1];
                    else if(s.charAt(i-2) == '*') w[i] = w[i-1] + w[i-2]*(Integer.parseInt(Character.toString(s.charAt(i-1))) < 7 ? 2 : 1);
                    else if(s.charAt(i-2) == '1') w[i] = w[i-1] + w[i-2];
                    else if(s.charAt(i-2) == '2'){
                        int t = Integer.parseInt(Character.toString(s.charAt(i-1)));
                        if(t < 7)  w[i] = w[i-1]+ w[i-2];
                        else w[i] = w[i-1];
                    }else{
                        w[i] = w[i-1];
                    }
                }
            }
            w[i] = w[i]%((Math.pow(10,9)+7));
        }
        return (int)w[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("*********"));
    }
}
