package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2092. Find All People With Secret.
 */
class Problem2092 extends LeetcodeProblem {

    List<Integer> findAllPeople(int _n, int[][] _meetings, int _first) {
        boolean[] vis = new boolean[_n];
        vis[0] = true;
        vis[_first] = true;
        int m = _meetings.length;
        Arrays.sort(_meetings, Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < m;) {
            int j = i;
            while (j + 1 < m && _meetings[j + 1][2] == _meetings[i][2]) {
                j++;
            }
            Map<Integer, List<Integer>> g = new HashMap<>();
            Set<Integer> s = new HashSet<>();
            for (int k = i; k <= j; k++) {
                int x = _meetings[k][0];
                int y = _meetings[k][1];
                g.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
                g.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
                s.add(x);
                s.add(y);
            }
            Deque<Integer> q = s.stream().filter(u -> vis[u]).collect(Collectors.toCollection(ArrayDeque::new));
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g.getOrDefault(u, List.of())) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }
            i = j + 1;
        }
        return IntStream.range(0, _n).filter(i -> vis[i]).boxed().collect(Collectors.toList());
    }

}
