package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0904 extends LeetcodeProblem {

    int totalFruit(int[] _tree) {
        int maxFruits = 0;
        Set<Integer> set = new HashSet<>();
        int startIndex = 0;
        for (int i = 0; i < _tree.length; i++) {
            if (set.size() < 2 || set.contains(_tree[i])) {
                set.add(_tree[i]);
                maxFruits = Math.max(maxFruits, i - startIndex + 1);
            } else {
                int lastOne = _tree[i - 1];
                for (int j = i - 2; j >= 0; j--) {
                    if (_tree[j] != lastOne) {
                        startIndex = j + 1;
                        set.remove(_tree[j]);
                        break;
                    }
                }
                set.add(_tree[i]);
                maxFruits = Math.max(maxFruits, i - startIndex + 1);
            }
        }
        return maxFruits;
    }

}
