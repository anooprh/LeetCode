package a013__Roman_To_Integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static Map<Character, Integer> table;
    static {
        table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);

    }

    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0 ; i < s.length(); ++i){
            char c = s.charAt(i);
            if(i != s.length()-1 && shouldDeduct(s.charAt(i), s.charAt(i+1)))res -= table.get(c);
            else res += table.get(c);
        }
        return res;
    }

    private boolean shouldDeduct(char now, char next) {
        return now == 'I' && (next == 'V' || next == 'X')
            || now == 'V' && (next == 'X')
            || now == 'X' && (next == 'L' || next == 'C')
            || now == 'L' && (next == 'C')
            || now == 'C' && (next == 'D' || next == 'M')
            || now == 'D' && (next == 'M');
    }

}
