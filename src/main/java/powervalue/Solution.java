package powervalue;


import java.util.ArrayList;

/**
 * @author tungdd
 */
class Solution {
    public static class Pair<K, V> {

        private final K element0;
        private final V element1;

        public static <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getKey() {
            return element0;
        }

        public V getValue() {
            return element1;
        }

    }
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