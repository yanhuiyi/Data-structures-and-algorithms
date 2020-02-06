package com.leetcode.problems;

import com.huwawei.interview.Problems1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problems71 {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] s = path.split("/");

    for(String t : s) {
      if(!t.equals(".") && !t.equals("") && !t.equals("..")) {
        stack.push(t);
      } else if(!stack.isEmpty() && t.equals("..")) {
        stack.pop();
      }
    }

    List<String> list = new ArrayList<>(stack);
    return "/" + String.join("/", list);
  }

  public static void main(String[] args) {
//    System.out.println(new Problems71().simplifyPath("/a/../../b/../c//.//"));
    System.out.println(new Problems71().simplifyPath("/a//b////c/d//././/.."));
  }
}
