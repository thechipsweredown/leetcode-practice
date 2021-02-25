package countbits;

public class Solution {
    public static boolean isPowerOfTwo(int n){
        if(n==0)
            return false;

        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
                (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }

    public static int[] countBits(int num) {
        int[] array = new int[num+1];
        if(num == 0){
            array[0] = 0;
        }else if(num == 1){
            array[0] = 0;
            array[1] = 1;
        }else if(num == 2){
            array[0] = 0;
            array[1] = 1;
            array[2] = 1;
        }else{
            array[0] = 0;
            array[1] = 1;
            array[2] = 1;
            int max = 2;
            for(int i=3; i<=num;i++){
                if(isPowerOfTwo(i)){
                    max = i;
                    array[i] = 1;
                }else{
                    array[i] = array[i-max] + array[max];
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int n = 3;
        for(int i : countBits(n)){
            System.out.print(i+" ");
        }
    }
}