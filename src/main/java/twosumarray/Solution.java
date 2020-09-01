package twosumarray;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'performOperations' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER_ARRAY op
     */
    
    public static List<Long> performOperations(int N, List<Integer> op) {
        // Write your code here
        ArrayList<Long> results = new ArrayList<>();
        HashSet<Long> nop = new HashSet<>();
        HashSet<Long> del = new HashSet<>();
        long head = 1L;
        long tail = N;
        long sum = (head+tail)*N/2;
        for(Integer i : op){
            Long o = new Long(i);
            if( (o <= N && !del.contains(o)) || (nop.contains(o) && !del.contains(o))){
                results.add(sum);
                long tmp = tail;
                tail = head;
                head = tmp;
            }else{
                del.add(tail);
                sum -= tail;
                sum += o;
                nop.add(o);
                tail = o;
                del.remove(o);
                results.add(sum);
            }
        }
        return results;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("conf/input13.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("conf/output"));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int N = Integer.parseInt(firstMultipleInput[0]);
        
        int M = Integer.parseInt(firstMultipleInput[1]);
        
        List<Integer> op = IntStream.range(0, M).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                               .map(String::trim)
                               .map(Integer::parseInt)
                               .collect(toList());
        long start = System.currentTimeMillis();
        List<Long> result = Result.performOperations(N, op);
        System.out.println(System.currentTimeMillis() - start);
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
