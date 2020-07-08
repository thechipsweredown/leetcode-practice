package triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> state = new ArrayList<>();
        state.add(0, triangle.get(0));
        for(int i=1; i<triangle.size();i++){
            List<Integer> row = triangle.get(i);
            List<Integer> minrow = new ArrayList<>();
            for(int j=0; j < row.size(); j++){
                List<Integer> prevrow = state.get(i-1);
                if(j == 0){
                    minrow.add(0, row.get(j) + prevrow.get(0));
                }else if(j < row.size()-1){
                    minrow.add(j,Math.min(prevrow.get(j)+row.get(j), prevrow.get(j-1) +row.get(j)));
                }else{
                    minrow.add(j, row.get(j) + prevrow.get(prevrow.size()-1));
                }
            }
            state.add(i,minrow);
        }
        return Collections.min(state.get(state.size()-1));
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(new Solution().minimumTotal(list));
    }
}