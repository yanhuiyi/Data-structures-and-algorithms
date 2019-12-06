package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();

        for(int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow = curRow + (goingDown ? 1 : -1);
        }

        StringBuilder ret = new StringBuilder();
        for(StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        String ret = convert("PAYPALISHIRING", 3);
        System.out.println(ret);

        String ret2 = convert("PAYPALISHIRING", 1);
        System.out.println(ret2);
    }
}
