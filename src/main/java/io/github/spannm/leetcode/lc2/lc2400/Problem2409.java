package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2409. Count Days Spent Together.
 */
class Problem2409 extends LeetcodeProblem {

    private static final int[] DAYS = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int countDaysTogether(
        String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String a = arriveAlice.compareTo(arriveBob) < 0 ? arriveBob : arriveAlice;
        String b = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
        int x = f(a);
        int y = f(b);
        return Math.max(y - x + 1, 0);
    }

    private int f(String s) {
        int i = Integer.parseInt(s.substring(0, 2)) - 1;
        int res = 0;
        for (int j = 0; j < i; j++) {
            res += DAYS[j];
        }
        res += Integer.parseInt(s.substring(3));
        return res;
    }

}
