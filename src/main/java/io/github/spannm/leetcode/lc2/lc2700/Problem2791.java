package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2791. Count Paths That Can Form a Palindrome in a Tree.
 */
class Problem2791 extends LeetcodeProblem {

    private List<int[]>[]               g;
    private final Map<Integer, Integer> cnt = new HashMap<>();
    private long                        ans;

    long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        @SuppressWarnings("unchecked")
        List<int[]>[] lists = new List[n];
        g = lists;
        cnt.put(0, 1);
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int p = parent.get(i);
            g[p].add(new int[] {i, 1 << s.charAt(i) - 'a'});
        }
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int xor) {
        for (int[] e : g[i]) {
            int j = e[0];
            int v = e[1];
            int x = xor ^ v;
            ans += cnt.getOrDefault(x, 0);
            for (int k = 0; k < 26; k++) {
                ans += cnt.getOrDefault(x ^ 1 << k, 0);
            }
            cnt.merge(x, 1, Integer::sum);
            dfs(j, x);
        }
    }

}
