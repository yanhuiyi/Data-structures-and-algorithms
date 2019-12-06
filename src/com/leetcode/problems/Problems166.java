package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) throw new ArithmeticException();

        boolean sign = (numerator > 0) ^ (denominator < 0);

        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);

        String intPart = String.valueOf(dividend / divisor);

        intPart = sign ? intPart : "-" + intPart;

        long reminder = dividend % divisor;

        if(reminder == 0) return intPart;

        Map<Long, Integer> map = new HashMap<>();
        StringBuilder decimalPart = new StringBuilder();

        while(reminder != 0) {
           map.put(reminder, decimalPart.length());
           reminder *= 10;
           decimalPart.append(reminder / divisor);
           reminder = reminder % divisor;

           if(map.containsKey(reminder)) {
               decimalPart.insert(map.get(reminder), "(");
               decimalPart.append(')');
               break;
           }
        }

        return intPart + "." + decimalPart.toString();
    }

    public static void main(String[] args) {
       System.out.println(new Problems166().fractionToDecimal(22, 7));
    }
}
