package a006__ZigZag_Conversion;

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length(), l = 0;
        if (numRows <= 1) return s;
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < n; j = j + (2 * (numRows - 1))) {
                sb.setCharAt(l++, s.charAt(j));
                if (i > 0 && i < numRows - 1 && (j + 2 * (numRows - i - 1) < n)) {
                    sb.setCharAt(l++, (s.charAt(j + (2 * (numRows - i - 1)))));
                }
            }
        }
        return sb.toString();
    }
}