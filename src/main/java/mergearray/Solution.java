package mergearray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] data = input.nextLine().split(" ");

        long[] arr = new long[n];
        for (int j = 0; j < n; j++) {
            arr[j] = Long.parseLong(data[j]);
        }

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            long num = arr[i];
            while (map.containsKey(num)) {
                arr[map.get(num)] = -1;
                map.remove(num);
                num = num * 2;
            }
            map.put(num, i);
            arr[i] = num;
        }
        System.out.println(map.size());
        for (long k : arr) {
            if (k != -1) System.out.print(k + " ");
        }
    }
}
