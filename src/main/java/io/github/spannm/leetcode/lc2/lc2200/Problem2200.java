package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem2200 extends LeetcodeProblem {

    List<Integer> findKDistantIndices(int[] _nums, int _key, int _k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> keyIndices = new ArrayList<>();
        for (int i = 0; i < _nums.length; i++) {
            if (_nums[i] == _key) {
                keyIndices.add(i);
            }
        }
        for (int i = 0; i < _nums.length; i++) {
            for (Integer keyIndex : keyIndices) {
                if (Math.abs(i - keyIndex) <= _k) {
                    ans.add(i);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

}
