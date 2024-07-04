package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2220 extends LeetcodeProblem {

    int minBitFlips(int _start, int _goal) {
        String sBin = Integer.toBinaryString(_start);
        String s = String.format("%32s", sBin).replaceAll(" ", "0");
        String gBin = Integer.toBinaryString(_goal);
        String g = String.format("%32s", gBin).replaceAll(" ", "0");
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != g.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }

}
