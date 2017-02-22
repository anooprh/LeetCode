package a007__Reverse_Integer;

public class Solution {
    public int reverse(int x) {
        boolean positive = true;
        long ans = 0;
        if (x < 0) {
            x = -x;
            positive = false;
        }
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        if (ans > Integer.MAX_VALUE) ans = 0;
        if (!positive) ans = -ans;
        return (int) ans;
    }
}