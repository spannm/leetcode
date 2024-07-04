package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem0624 extends LeetcodeProblem {

    int maxDistance(List<List<Integer>> _arrays) {
        List<Integer> max = new ArrayList<>();
        for (List<Integer> array : _arrays) {
            max.add(array.get(array.size() - 1));
        }
        Collections.sort(max);
        int ans = Integer.MIN_VALUE;
        for (List<Integer> array : _arrays) {
            int big = array.get(array.size() - 1) == max.get(max.size() - 1) ? max.get(max.size() - 2) : max.get(max.size() - 1);
            ans = Math.max(ans, big - array.get(0));
        }
        return ans;
    }

}
