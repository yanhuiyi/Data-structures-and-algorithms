package com.leetcode.problems;

import java.util.Arrays;

public class Problems43 {
    public String multiply(String num1, String num2) {
      String res = "";
        //StringBuilder res = new StringBuilder("");
      int m = num1.length(), n = num2.length();
      int[] vals = new int[m + n];

      for(int i = m - 1; i >= 0; --i) {
          for (int j = n - 1; j >= 0; --j) {
              int mu1 = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
              int p1 = i + j, p2 = i + j + 1, sum = mu1 + vals[p2];
              vals[p1] += sum / 10;
              vals[p2] = sum % 10;
          }
      }

      for(int val : vals) {
          if (res.length() != 0 || val != 0) res = res.concat(val + "");
      }

      return res.length() == 0 ? "0" : res;
    }

    public static void main(String[] args) {
//        System.out.println(new Problems43().multiply("2", "3"));
        System.out.println(new Problems43().multiply("123", "456"));
    }
}
