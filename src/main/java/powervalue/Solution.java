package powervalue;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * @author tungdd
 */
class Solution {
    public int sort(ArrayList<Pair<Integer,Integer>> arrayList, int k){
        Pair<Integer,Integer>[] array = (Pair<Integer, Integer>[]) arrayList.toArray(new Pair[arrayList.size()]);
        Pair<Integer,Integer> temp;
        for (int i = 1; i < arrayList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].getKey() < array[j-1].getKey()) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j - 1] = temp;
                }
            }
        }
        return array[k-1].getValue();
    }
    public int getKth(int lo, int hi, int k) {
        ArrayList<Pair<Integer,Integer>> arrayList = new ArrayList<>();
        for(int i = lo; i <= hi; i++){
            int r = kstep(i);
            arrayList.add(new Pair<>(r, i));
        }
        return sort(arrayList,k);

    }
    public int kstep(int num){
        int step = 0;
        while(num != 1){
            step += 1;
            if(num % 2 == 0)
                num = num/2;
            else num = 3*num + 1;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getKth(1,1000,777));
    }
}