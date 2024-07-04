package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1585. Check If String Is Transformable With Substring Sort Operations.
 */
class Problem1585 extends LeetcodeProblem {

    boolean isTransformable(String _s, String _t) {
        @SuppressWarnings("unchecked")
        Deque<Integer>[] pos = new Deque[10];
        Arrays.setAll(pos, k -> new ArrayDeque<>());
        for (int i = 0; i < _s.length(); i++) {
            pos[_s.charAt(i) - '0'].offer(i);
        }
        for (int i = 0; i < _t.length(); i++) {
            int x = _t.charAt(i) - '0';
            if (pos[x].isEmpty()) {
                return false;
            }
            for (int j = 0; j < x; j++) {
                if (!pos[j].isEmpty() && pos[j].peek() < pos[x].peek()) {
                    return false;
                }
            }
            pos[x].poll();
        }
        return true;
    }

}
