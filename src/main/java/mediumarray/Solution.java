package mediumarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        if((n1+n2) % 2 == 0){
            list1.addAll(list2);
            Collections.sort(list1);
            return (list1.get(n/2)*1.0 + list1.get(n/2 - 1)*1.0)/2;
        }else{
            list1.addAll(list2);
            Collections.sort(list1);
            return list1.get((n - 1)/2)*1.0;
        }
    }

    public static void main(String[] args) {
        int[] n1 = {1,2};
        int[] n2 = {3,4};
        System.out.println(new Solution().findMedianSortedArrays(n1,n2));
    }
}