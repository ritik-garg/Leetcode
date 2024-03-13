class Solution {
    public int pivotInteger(int n) {
        n = n * (n + 1) / 2;
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return sqrt;
        }
        return -1;
    }
}