package waterjug;

class Solution {
    public int egcd(int a, int b) {
        if (a == 0)
            return b;
        while (b != 0) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        return a;
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        int gcd = egcd(x,y);
        System.out.println(gcd);
        if (gcd == 0 && z!=0)
            return false;
        if( gcd!= 0 && z%gcd != 0)
            return false;
        return true;
    }
}
