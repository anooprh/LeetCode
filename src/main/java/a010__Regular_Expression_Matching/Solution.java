package a010__Regular_Expression_Matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        final int s_l = s.length();
        final int p_l = p.length();
        int p_idx = 0, s_idx = 0;
        char prev = 0;
        while (s_idx < s_l && p_idx < p_l) {
            if (p.charAt(p_idx) != '.' && p.charAt(p_idx) != '*') {
                if (p.charAt(p_idx) != s.charAt(s_idx)) {
                    if (p_idx < p_l - 1 && p.charAt(p_idx + 1) == '*') {
                        prev = p.charAt(p_idx);
                        p_idx++;
                        p_idx++;
                        continue;
                    } else
                        return false;
                }
                prev = p.charAt(p_idx);
                p_idx++;
                s_idx++;
            } else if (p.charAt(p_idx) == '.') {
                prev = 0;
                p_idx++;
                s_idx++;
            } else {
                if (s_idx == 0) return false;
                p_idx++;
                while (s_idx < s_l && (prev == 0 || s.charAt(s_idx) == prev)) {
                    s_idx++;
                }
            }
        }
        if (s_idx < s_l || p_idx < p_l) return false;
        return true;
    }
}
