package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Problem2349 extends LeetcodeProblem {

    static class NumberContainers {
        private final Map<Integer, Integer>          mp = new HashMap<>();
        private final Map<Integer, TreeSet<Integer>> t  = new HashMap<>();

        public void change(int index, int number) {
            if (mp.containsKey(index)) {
                int v = mp.get(index);
                t.get(v).remove(index);
                if (t.get(v).isEmpty()) {
                    t.remove(v);
                }
            }
            mp.put(index, number);
            t.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
        }

        public int find(int number) {
            return t.containsKey(number) ? t.get(number).first() : -1;
        }

    }

}
