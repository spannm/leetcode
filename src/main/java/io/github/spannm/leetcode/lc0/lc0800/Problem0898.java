package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 898. Bitwise ORs of Subarrays.
 */
class Problem0898 extends LeetcodeProblem {

    int subarrayBitwiseORs(int[] _arr) {
        Set<Integer> s = new HashSet<>();
        s.add(0);
        Set<Integer> ans = new HashSet<>();
        for (int x : _arr) {
            Set<Integer> t = new HashSet<>();
            for (int y : s) {
                t.add(x | y);
            }
            t.add(x);
            s = t;
            ans.addAll(s);
        }
        return ans.size();
    }

}
