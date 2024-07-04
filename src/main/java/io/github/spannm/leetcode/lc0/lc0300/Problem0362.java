package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0362 extends LeetcodeProblem {

    static class HitCounter {
        private final int[] times;
        private final int[] hits;
        private final int   k;

        HitCounter() {
            k = 300;
            times = new int[k];
            hits = new int[k];
        }

        void hit(int _timestamp) {
            int index = _timestamp % k;
            if (times[index] != _timestamp) {
                times[index] = _timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        int getHits(int _timestamp) {
            int total = 0;
            for (int i = 0; i < k; i++) {
                if (_timestamp - times[i] < k) {
                    total += hits[i];
                }
            }
            return total;
        }
    }

}
