package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1719. Number Of Ways To Reconstruct A Tree.
 */
class Problem1719 extends LeetcodeProblem {

    int checkWays(int[][] pairs) {
        boolean[][] g = new boolean[510][510];
        @SuppressWarnings("unchecked")
        List<Integer>[] v = new List[510];
        Arrays.setAll(v, k -> new ArrayList<>());
        for (int[] p : pairs) {
            int x = p[0];
            int y = p[1];
            g[x][y] = true;
            g[y][x] = true;
            v[x].add(y);
            v[y].add(x);
        }
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < 510; i++) {
            if (!v[i].isEmpty()) {
                nodes.add(i);
                g[i][i] = true;
            }
        }
        nodes.sort(Comparator.comparingInt(a -> v[a].size()));
        boolean equal = false;
        int root = 0;
        for (int i = 0; i < nodes.size(); i++) {
            int x = nodes.get(i);
            int j = i + 1;
            while (j < nodes.size() && !g[x][nodes.get(j)]) {
                j++;
            }
            if (j < nodes.size()) {
                int y = nodes.get(j);
                if (v[x].size() == v[y].size()) {
                    equal = true;
                }
                for (int z : v[x]) {
                    if (!g[y][z]) {
                        return 0;
                    }
                }
            } else {
                root++;
            }
        }
        if (root > 1) {
            return 0;
        }
        return equal ? 2 : 1;
    }

}
