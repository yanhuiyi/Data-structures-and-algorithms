package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    public boolean isLeaf;
    Map<Character, TrieNode> children;

    public TrieNode() {
        isLeaf = false;
        children = new HashMap<>();
    }
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    private TrieNode searchNode(String pre) {
        Map<Character, TrieNode> children = root.children;
        TrieNode node = root;

        for(int i = 0; i < pre.length(); i++) {
            if(!children.containsKey(pre.charAt(i))) {
                return null;
            }

            node = children.get(pre.charAt(i));
            children = node.children;
        }

        return node;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!children.containsKey(c)) {
               TrieNode node = new TrieNode();
               children.put(c, node);
            }

            TrieNode node = children.get(c);
            if(i == word.length() - 1) {
                node.isLeaf = true;
            }
            children = node.children;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isLeaf == true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

}

public class Problems208 {
  public static void main(String[] args) {
      Trie trie = new Trie();
      trie.insert("apple");
      System.out.println(trie.search("apple"));
      System.out.println(trie.search("app"));
      System.out.println(trie.startsWith("app"));
      trie.insert("app");
      System.out.println(trie.search("app"));
  }
}
