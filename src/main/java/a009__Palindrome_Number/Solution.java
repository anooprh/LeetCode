package a009__Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return x == findRev(x);
    }

    private int findRev(int x) {
        int ans = 0;
        while (x != 0) {
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        return ans;
    }
}