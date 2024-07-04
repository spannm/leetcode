package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.NestedInteger;

import java.util.List;

class Problem0339 extends LeetcodeProblem {
    private int sum = 0;

    int depthSum(List<NestedInteger> _nestedList) {
        return dfs(_nestedList, 1);
    }

    int dfs(List<NestedInteger> _nestedList, int _depth) {
        for (NestedInteger ni : _nestedList) {
            if (ni.isInteger()) {
                sum += _depth * ni.getInteger();
            } else {
                dfs(ni.getList(), _depth + 1);
            }
        }
        return sum;
    }

}
