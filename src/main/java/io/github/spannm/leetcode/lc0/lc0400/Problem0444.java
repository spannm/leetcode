package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0444 extends LeetcodeProblem {

    boolean sequenceReconstruction(int[] _org, List<List<Integer>> _seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : _seqs) {
            if (seq.size() == 1) {
                if (!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            } else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    if (!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }

                    if (!map.containsKey(seq.get(i + 1))) {
                        map.put(seq.get(i + 1), new HashSet<>());
                        indegree.put(seq.get(i + 1), 0);
                    }

                    if (map.get(seq.get(i)).add(seq.get(i + 1))) {
                        indegree.put(seq.get(i + 1), indegree.get(seq.get(i + 1)) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int curr = queue.poll();
            if (index == _org.length || curr != _org[index++]) {
                return false;
            }
            for (int next : map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == _org.length && index == map.size();
    }

}
