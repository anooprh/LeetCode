package a005__Longest_Palindromic_Substring;

public class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        int[] odd = new int[l];
        int[] even = new int[l - 1];
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < l; ++i) {
            odd[i] = expand_odd(s, i);
            if(odd[i] > maxLen){

                maxLen = odd[i];
                ans = s.substring(i-odd[i]/2, i+odd[i]/2+1);
            }
        }
        for (int i = 0; i < l - 1; ++i) {
            even[i] = expand_even(s, i);
            if(even[i] > maxLen){
                maxLen = even[i];
                ans = s.substring(i-even[i]/2+1, i+even[i]/2+1);
            }
        }

        return ans;
    }

    private int expand_even(String s, int pos) {
        int i = 0;
        while (pos - i >= 0 && pos + 1 + i < s.length() && s.charAt(pos - i) == s.charAt(pos + 1 + i)) i++;
        return i*2;
    }

    private int expand_odd(String s, int pos) {
        int i = 0;
        while (pos - i >= 0 && pos + i < s.length() && s.charAt(pos - i) == s.charAt(pos + i)) i++;
        return i*2 - 1;
    }
}
