package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2671 extends LeetcodeProblem {

    static class FrequencyTracker {
        private final Map<Integer, Integer> cnt  = new HashMap<>();
        private final Map<Integer, Integer> freq = new HashMap<>();

        void add(int number) {
            int f = cnt.getOrDefault(number, 0);
            if (freq.getOrDefault(f, 0) > 0) {
                freq.merge(f, -1, Integer::sum);
            }
            cnt.merge(number, 1, Integer::sum);
            freq.merge(f + 1, 1, Integer::sum);
        }

        void deleteOne(int number) {
            int f = cnt.getOrDefault(number, 0);
            if (f == 0) {
                return;
            }
            freq.merge(f, -1, Integer::sum);
            cnt.merge(number, -1, Integer::sum);
            freq.merge(f - 1, 1, Integer::sum);
        }

        boolean hasFrequency(int frequency) {
            return freq.getOrDefault(frequency, 0) > 0;
        }

    }
}
