package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0911 extends LeetcodeProblem {

    static class TopVotedCandidate {
        private final int[] times;
        private final int[] wins;

        TopVotedCandidate(int[] _persons, int[] _times) {
            int n = _persons.length;
            int mx = 0;
            int cur = 0;
            times = _times;
            wins = new int[n];
            int[] counter = new int[n];
            for (int i = 0; i < n; i++) {
                int p = _persons[i];
                if (++counter[p] >= mx) {
                    mx = counter[p];
                    cur = p;
                }
                wins[i] = cur;
            }
        }

        int q(int t) {
            int left = 0;
            int right = wins.length - 1;
            while (left < right) {
                int mid = left + right + 1 >>> 1;
                if (times[mid] <= t) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return wins[left];
        }

    }

}
