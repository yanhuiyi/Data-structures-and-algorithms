package com.leetcode.problems;

import java.util.*;

public class Problems380 {
   Map<Integer, Integer> map;
  List<Integer> list;
  int size;
  Random rand;

    public Problems380() {
       this.map = new HashMap<>();
       this.list = new ArrayList<>();
       this.size = 0;
       this.rand = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, size);
        list.add(val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int last = list.get(size - 1);
            list.set(map.get(val), last);
            map.put(last, map.get(val));
            map.remove(val);
            list.remove(size - 1);
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(rand.nextInt(size));
    }

    public static void main(String[] args) {
        Problems380 p = new Problems380();
        p.insert(1);
        p.remove(2);
        p.insert(2);
        p.getRandom();
        p.remove(1);
        p.insert(2);
        p.getRandom();
    }
}

