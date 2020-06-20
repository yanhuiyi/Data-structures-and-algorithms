package com.hankerrank.interviewpreparationkit.warmup;

public class Solution4 {

    static int countOf(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == c)
                count++;
        return count;
    }

    static long repeatedString(String s, long n) {
        long a = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                a++;
        }

        long t = a * (n / s.length());

        long diff = n % s.length();

        for(int i = 0; i < diff; i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                t++;
        }

        return t;

    }

    static long repeatedString2(String s, long n) {
        long a = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                a++;
        }

        long t = a * (n / s.length());

        long diff = n % s.length();

        for (int i = 0; i < diff; i++) {
            char ch = s.charAt(i);

            if (ch == 'a')
                t++;
        }
        return (t);
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("a", 1000000000000L));
    }
}
