package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2502 extends LeetcodeProblem {

    static class Allocator {
        private final Map<Integer, Integer>       tm = new TreeMap<>();
        private final Map<Integer, List<Integer>> d  = new HashMap<>();

        Allocator(int n) {
            tm.put(-1, -1);
            tm.put(n, n);
        }

        int allocate(int size, int mID) {
            int s = -1;
            for (var entry : tm.entrySet()) {
                int v = entry.getKey();
                if (s != -1) {
                    int e = v - 1;
                    if (e - s + 1 >= size) {
                        tm.put(s, s + size - 1);
                        d.computeIfAbsent(mID, k -> new ArrayList<>()).add(s);
                        return s;
                    }
                }
                s = entry.getValue() + 1;
            }
            return -1;
        }

        int free(int mID) {
            int ans = 0;
            for (int s : d.getOrDefault(mID, List.of())) {
                int e = tm.remove(s);
                ans += e - s + 1;
            }
            d.remove(mID);
            return ans;
        }

    }

}
