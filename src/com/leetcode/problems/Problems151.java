package com.leetcode.problems;

public class Problems151 {
    public String reverseWords(String s) {
        if(s == null) return s;
        char[] c = s.toCharArray();

        int n = c.length;

        reverse(c, 0, n - 1);

        reverseWords(c, n);

        //"example   good a"

        return cleanSpaces(c, n);
    }

    private void reverseWords(char[] c, int n) {
        int i = 0, j = 0;
        while(i < n) {
            while(j < n && c[j] != ' ')
                ++j;
            reverse(c, i, j - 1);
            i = ++j;
        }
    }

    private void reverse(char[] c, int i, int j) {
        while(i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ')
                a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    public static void main(String[] args) {
        String s = new Problems151().reverseWords("x abc  def  ");
        System.out.println(s);
    }
}
