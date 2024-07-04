package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2241 extends LeetcodeProblem {

    static class ATM {
        private static final int[] D   = {20, 50, 100, 200, 500};
        private final long[]       cnt = new long[5];

        ATM() {
        }

        void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                cnt[i] += banknotesCount[i];
            }
        }

        int[] withdraw(int amount) {
            int[] ans = new int[5];
            for (int i = 4; i >= 0; i--) {
                ans[i] = (int) Math.min(amount / D[i], cnt[i]);
                amount -= ans[i] * D[i];
            }
            if (amount > 0) {
                return new int[] {-1};
            }
            for (int i = 0; i < 5; i++) {
                cnt[i] -= ans[i];
            }
            return ans;
        }

    }

}
