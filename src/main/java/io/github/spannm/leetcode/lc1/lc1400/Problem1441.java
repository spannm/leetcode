package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Problem1441 extends LeetcodeProblem {

    List<String> buildArray(int[] _target, int _n) {
        List<String> result = new ArrayList<>();
        Set<Integer> set = Arrays.stream(_target).boxed().collect(Collectors.toSet());
        int max = _target[_target.length - 1];
        for (int i = 1; i <= _n; i++) {
            result.add("Push");
            if (!set.contains(i)) {
                result.add("Pop");
            }
            if (i == max) {
                break;
            }
        }
        return result;
    }

}
