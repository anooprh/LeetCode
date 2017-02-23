package a008__String_To_Integer;

public class Solution {
    public int myAtoi(String str) {
        int ans = 0;
        int firstNonWhite = getFirstNonWhiteIdx(str);
        if (firstNonWhite == str.length())
            return ans;
        String leadingWhiteSpaceRemoved = str.substring(firstNonWhite, str.length());

        int stop, start = -1;

        boolean positive = leadingWhiteSpaceRemoved.charAt(0) != '-';

        String signCorrected = performSignCorrection(leadingWhiteSpaceRemoved);

        if (signCorrected.length() == 0 || !isValidDigit(signCorrected, 0)) {
            return ans;
        }

        stop = signCorrected.length();
        for (int i = 0; i < signCorrected.length(); ++i) {
            boolean validDigit = isValidDigit(signCorrected, i);
            if (start == -1 && validDigit && signCorrected.charAt(i) != '0') {
                start = i;
            }

            if (!validDigit) {
                stop = i;
                break;
            }
        }
        if (start == -1) return ans;

        if (stop - start < 0) return ans;
        if (stop - start > 10) {
            if (positive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        if (stop - start > 10) {
            if (positive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }

        String num = signCorrected.substring(start, stop);
        long l = Long.parseLong(num);
        if (l > Integer.MAX_VALUE) {
            if (!positive) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        if (!positive) return (int) -l;
        else return (int) l;
    }

    private boolean isValidDigit(String s, int idx) {
        return s.charAt(idx) >= '0' && s.charAt(idx) <= '9';
    }

    private String performSignCorrection(String s) {
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1, s.length());
        }
        return s;
    }

    private int getFirstNonWhiteIdx(String s) {
        int firstNonWhite = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ') {
                firstNonWhite = i;
                break;
            }
        }
        return firstNonWhite;
    }
}