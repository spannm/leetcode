package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Problem0310 extends LeetcodeProblem {

    List<Integer> findMinHeightTrees(int _n, int[][] _edges) {
        if (_n == 1) {
            return List.of(0);
        }

        List<Set<Integer>> adj = new ArrayList<>(_n);
        IntStream.range(0, _n).forEach(i -> adj.add(new HashSet<>()));
        for (int[] edge : _edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = IntStream.range(0, _n).filter(i -> adj.get(i).size() == 1).boxed().toList();

        while (_n > 2) {
            _n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

}
