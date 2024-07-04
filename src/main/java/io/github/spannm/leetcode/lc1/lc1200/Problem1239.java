package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters.
 */
class Problem1239 extends LeetcodeProblem {

    int maxLength(List<String> _arr) {
        int ans = 0;
        List<Integer> masks = new ArrayList<>();
        masks.add(0);
        for (String s : _arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int j = s.charAt(i) - 'a';
                if ((mask >> j & 1) == 1) {
                    mask = 0;
                    break;
                }
                mask |= 1 << j;
            }
            if (mask != 0) {
                int sz = masks.size();
                for (int i = 0; i < sz; i++) {
                    int m = masks.get(i);
                    if ((m & mask) == 0) {
                        masks.add(m | mask);
                        ans = Math.max(ans, Integer.bitCount(m | mask));
                    }
                }
            }
        }
        return ans;
    }

}
