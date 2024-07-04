package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/snapshot-array/">1146. Snapshot Array</a>.
 */
class Problem1146 extends LeetcodeProblem {

    static class SnapshotArray {

        private final List<Map<Integer, Integer>> snaps;

        SnapshotArray(int _length) {
            snaps = new ArrayList<>(_length);
            snaps.add(new HashMap<>());
        }

        public void set(int _index, int _val) {
            snaps.get(snaps.size() - 1).put(_index, _val);
        }

        public int snap() {
            snaps.add(new HashMap<>());
            return snaps.size() - 2;
        }

        public int get(int _index, int _snapId) {
            for (int i = _snapId; i >= 0; i--) {
                Integer val = snaps.get(i).get(_index);
                if (val != null) {
                    return val;
                }
            }
            return 0;
        }

    }

}
