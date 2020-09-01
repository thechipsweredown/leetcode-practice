package numlocks;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.*;


class Result {

    public static String charRemoveAt(String str, int p) {
        if(p > 5) return str.substring(0, p)+str.substring(p+1);
        else return "";
    }

    public static String insertAt(String str, int p, Character c) {
        return str.substring(0, p)+c+str.substring(p);
    }

    public static String receivedText(String S) {
        Character[] array = {'0','1','2','3','4','5','6','7','8','9'};
        List<Character> temp = Arrays.asList(array);
        HashSet<Character> set = new HashSet<>(temp);

        ArrayList<String> list = new ArrayList<>();
        int cur = 0;
        boolean numlock = true;

        for (int i=0; i<S.length();i++) {
            char c = S.charAt(i);
            switch (c) {
                case '<':
                    cur = 0;
                    break;
                case '*':
                    if(list.size() >=1 && cur > 0) list.remove(cur-1);
                    if (cur >= 2) cur = cur - 1;
                    else cur = 0;
                    break;
                case '>':
                    cur = list.size();
                    break;
                case '#':
                    numlock = !numlock;
                    break;
                default:
                    if (!numlock && set.contains(c)) continue;
                    if(cur == 0) list.add(0,Character.toString(c));
                    else if(cur == list.size()) list.add(Character.toString(c));
                    else list.add(cur, Character.toString(c));
                    cur += 1;
                    break;
            }
        }
        return StringUtils.join(list,"");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/input08.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/output.txt"));

        String S = bufferedReader.readLine();
        long start = System.currentTimeMillis();
        String result = Result.receivedText(S);
        System.out.println(System.currentTimeMillis() - start);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

