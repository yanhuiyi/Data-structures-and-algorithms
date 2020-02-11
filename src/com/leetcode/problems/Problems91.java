package com.leetcode.problems;

public class Problems91 {

    public int numDecodings2(String s) {
        if(s.isEmpty()) return 0;

        int[] result = new int[1];
        dfs(s, result);
        return result[0];
    }

    // Time exceeds
    private void dfs(String str, int[] result) {
        if (str.length() >= 1) {
            if (isValidLetter(str.substring(0, 1)))
                dfs(str.substring(1), result);
            else
                return;
        }

        if(str.length() >= 2) {
            if(isValidLetter(str.substring(0, 2)))
                dfs(str.substring(2), result);
            else
                return;
        }

        if(str.isEmpty())
            result[0]++;
    }

    private boolean isValidLetter(String substring) {
        if(substring.charAt(0) == '0')
            return false;
       int num;

       if(substring.length() == 1)
           num = substring.charAt(0) - '0';
       else
           num = (substring.charAt(0) - '0') * 10 + (substring.charAt(1) - '0');

       return num >= 1 && num <= 26;
    }

    public int numDecodings(String s) {
        if(s.isEmpty() || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
            if(i > 1 && (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' &&
                    s.charAt(i - 1) <= '6'))) {
               dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Problems91().numDecodings("226"));
    }
}
