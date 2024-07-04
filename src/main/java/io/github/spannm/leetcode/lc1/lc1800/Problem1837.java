package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1837 extends LeetcodeProblem {

    int sumBase(int _n, int _k) {
        String str = Integer.toString(Integer.parseInt(_n + "", 10), _k);
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

}
