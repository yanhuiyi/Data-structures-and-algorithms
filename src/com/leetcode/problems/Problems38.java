package com.leetcode.problems;

public class Problems38 {

    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        char[] res = countAndSay(n - 1).toCharArray();

        int count = 0;

        char cur = res[0];

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < res.length; i++) {
            if(cur != res[i]) {
                sb.append(count);
                sb.append(cur);
                cur = res[i];
                count = 1;
            } else {
                count++;
            }
        }

        sb.append(count > 0 ? count + String.valueOf(cur) : "");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problems38().countAndSay(5));
    }
}
