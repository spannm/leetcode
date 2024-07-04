package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0128 extends LeetcodeProblem {

    int longestConsecutive(int[] _nums) {
        Map<Integer, Integer> map = new HashMap<>();

        UnionFind uf = new UnionFind(_nums);
        for (int i = 0; i < _nums.length; i++) {
            if (!map.containsKey(_nums[i])) {
                map.put(_nums[i], i);
                if (map.containsKey(_nums[i] - 1)) {
                    uf.union(i, map.get(_nums[i] - 1));
                }
                if (map.containsKey(_nums[i] + 1)) {
                    uf.union(i, map.get(_nums[i] + 1));
                }
            }
        }
        return uf.maxUnion();
    }

    static class UnionFind {
        private final int   len;
        private final int[] ids;

        UnionFind(int[] _nums) {
            len = _nums.length;
            ids = new int[len];
            for (int i = 0; i < len; i++) {
                ids[i] = i;
            }
        }

        void union(int _i, int _j) {
            int x = find(ids, _i);
            int y = find(ids, _j);
            ids[x] = y;
        }

        static int find(int[] _ids, int _i) {
            while (_i != _ids[_i]) {
                _ids[_i] = _ids[_ids[_i]];
                _i = _ids[_i];
            }
            return _i;
        }

        boolean connected(int _i, int _j) {
            return find(ids, _i) == find(ids, _j);
        }

        int maxUnion() {
            int[] count = new int[len];
            int max = 0;
            for (int i = 0; i < len; i++) {
                count[find(ids, i)]++;
                max = Math.max(max, count[find(ids, i)]);
            }
            return max;
        }
    }

}
