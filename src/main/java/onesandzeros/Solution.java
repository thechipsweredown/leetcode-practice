package onesandzeros;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(m <= 0) return 0;
        if(n <= 0) return 0;
        
        int[][] max=new int[m+1][n+1];
        for(String s:strs){
            int str0 = (int)s.chars().filter(num -> num=='0').count();
            int str1= (int)s.chars().filter(num -> num=='1').count();
            for(int i=m;i>=str0;i--){
                for(int j=n;j>=str1;j--){
                    max[i][j]=Math.max(max[i][j],max[i-str0][j-str1]+1);
                }
            }
        }
        return max[m][n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxForm(new String[]{"10","0001","111001","1","0"},9,3));
    }
}
