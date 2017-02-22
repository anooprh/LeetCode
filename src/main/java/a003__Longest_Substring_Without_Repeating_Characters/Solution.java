package a003__Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                ans = Math.max(i - st, ans);

                st = Math.max(st, map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i), i);
            }
        }
        ans = Math.max(s.length() - st, ans);
        return ans;
    }
}
