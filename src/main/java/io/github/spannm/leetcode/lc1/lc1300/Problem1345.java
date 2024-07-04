package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <p>
 * <a href="https://leetcode.com/problems/jump-game-iv/">1345. Jump Game IV</a>.
 *
 * <p>
 * <a href=
 * "https://leetcode.com/problems/jump-game-iv/solutions/1690813/best-explanation-ever-possible-for-this-question/?orderBy=most_votes&languageTags=java">Solution</a>
 */
class Problem1345 extends LeetcodeProblem {

    int minJumps(int[] _arr) {
        final int len = _arr.length;

        if (len == 1) {
            return 0;
        }

        final Map<Integer, List<Integer>> map = new HashMap<>();
        int step = 0;

        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(_arr[i], v -> new ArrayList<>()).add(i);
        }

        Deque<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int j = q.poll();

                if (j - 1 >= 0 && map.containsKey(_arr[j - 1])) {
                    q.offer(j - 1);
                }

                if (j + 1 < len && map.containsKey(_arr[j + 1])) {
                    if (j + 1 == len - 1) {
                        return step;
                    }
                    q.offer(j + 1);
                }

                if (map.containsKey(_arr[j])) {
                    for (int k : map.get(_arr[j])) {
                        if (k != j) {
                            if (k == len - 1) {
                                return step;
                            }
                            q.offer(k);
                        }
                    }
                }
                map.remove(_arr[j]);
            }
        }

        return step;
    }

}
