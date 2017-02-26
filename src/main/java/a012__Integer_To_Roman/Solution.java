package a012__Integer_To_Roman;

import java.util.HashMap;

public class Solution {

    private HashMap<Integer, String> table;

    public String intToRoman(int num) {
        initializeTable();
        int mul = 1;
        String res = "";
        while (num > 0) {
            if (num % 10 != 0) {
                res = table.get((num % 10) * mul) + res;
            }
            mul = mul * 10;
            num = num / 10;
        }
        return res;
    }

    private void initializeTable() {
        table = new HashMap<>();
        table.put(0, "");
        table.put(1, "I");
        table.put(2, "II");
        table.put(3, "III");
        table.put(4, "IV");
        table.put(5, "V");
        table.put(6, "VI");
        table.put(7, "VII");
        table.put(8, "VIII");
        table.put(9, "IX");
        table.put(10, "X");
        table.put(20, "XX");
        table.put(30, "XXX");
        table.put(40, "XL");
        table.put(50, "L");
        table.put(60, "LX");
        table.put(70, "LXX");
        table.put(80, "LXXX");
        table.put(90, "XC");
        table.put(100, "C");
        table.put(200, "CC");
        table.put(300, "CCC");
        table.put(400, "CD");
        table.put(500, "D");
        table.put(600, "DC");
        table.put(700, "DCC");
        table.put(800, "DCCC");
        table.put(900, "CM");
        table.put(1000, "M");
        table.put(2000, "MM");
        table.put(3000, "MMM");
    }
}
