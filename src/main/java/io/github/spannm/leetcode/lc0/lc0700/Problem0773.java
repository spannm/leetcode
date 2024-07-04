package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Pair;

import java.util.*;

/**
 * 773. Sliding Puzzle.
 */
class Problem0773 extends LeetcodeProblem {

    private final int m = 2;
    private final int n = 3;

    int slidingPuzzle(int[][] _board) {
        String start = "";
        String end = "123450";
        String seq = "";
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                start += _board[r][c];
                if (_board[r][c] != 0) {
                    seq += _board[r][c];
                }
            }
        }
        if (!check(seq)) {
            return -1;
        }
        Queue<Pair<Integer, String>> q = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        Map<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        q.offer(new Pair<>(f(start), start));
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            String state = q.poll().getValue();
            int step = dist.get(state);
            if (end.equals(state)) {
                return step;
            }
            int p1 = state.indexOf('0');
            int i = p1 / n;
            int j = p1 % n;
            char[] s = state.toCharArray();
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int p2 = x * n + y;
                    swap(s, p1, p2);
                    String next = String.valueOf(s);
                    if (!dist.containsKey(next) || dist.get(next) > step + 1) {
                        dist.put(next, step + 1);
                        q.offer(new Pair<>(step + 1 + f(next), next));
                    }
                    swap(s, p1, p2);
                }
            }
        }
        return -1;
    }

    private void swap(char[] _arr, int _i, int _j) {
        char t = _arr[_i];
        _arr[_i] = _arr[_j];
        _arr[_j] = t;
    }

    private int f(String _s) {
        int ans = 0;
        for (int i = 0; i < m * n; i++) {
            if (_s.charAt(i) != '0') {
                int num = _s.charAt(i) - '1';
                ans += Math.abs(i / n - num / n) + Math.abs(i % n - num % n);
            }
        }
        return ans;
    }

    static boolean check(String _s) {
        int len = _s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (_s.charAt(i) > _s.charAt(j)) {
                    cnt++;
                }
            }
        }
        return cnt % 2 == 0;
    }

}
