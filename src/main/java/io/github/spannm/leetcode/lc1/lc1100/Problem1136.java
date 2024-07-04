package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1136 extends LeetcodeProblem {

    int minimumSemesters(int _n, int[][] _relations) {
        Map<Integer, Set<Integer>> indegree = new HashMap<>();
        for (int[] rel : _relations) {
            if (!indegree.containsKey(rel[1])) {
                indegree.put(rel[1], new HashSet<>());
            }
            Set<Integer> prereqs = indegree.get(rel[1]);
            prereqs.add(rel[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> taken = new HashSet<>();
        for (int i = 1; i <= _n; i++) {
            if (!indegree.containsKey(i)) {
                queue.offer(i);
                taken.add(i);
            }
        }
        int minSemesters = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minSemesters++;
            for (int i = 0; i < size; i++) {
                Integer curr = queue.poll();
                for (int key : indegree.keySet()) {
                    Set<Integer> prereqs = indegree.get(key);
                    if (prereqs.contains(curr)) {
                        prereqs.remove(curr);
                        if (prereqs.isEmpty()) {
                            queue.offer(key);
                            taken.add(key);
                        }
                    }
                }
            }
        }
        return taken.size() != _n ? -1 : minSemesters;
    }

}
