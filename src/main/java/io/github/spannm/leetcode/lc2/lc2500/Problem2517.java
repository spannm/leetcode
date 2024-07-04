package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2517. Maximum Tastiness of Candy Basket.
 */
class Problem2517 extends LeetcodeProblem {

    int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0;
        int r = price[price.length - 1] - price[0];
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(price, k, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] price, int k, int x) {
        int cnt = 0;
        int pre = -x;
        for (int cur : price) {
            if (cur - pre >= x) {
                pre = cur;
                cnt++;
            }
        }
        return cnt >= k;
    }

}
