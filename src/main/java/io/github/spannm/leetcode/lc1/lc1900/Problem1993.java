package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1993 extends LeetcodeProblem {

    static class LockingTree {
        private final int[]           locked;
        private final int[]           parent;
        private final List<Integer>[] children;

        @SuppressWarnings("unchecked")
        LockingTree(int[] _parent) {
            int n = _parent.length;
            locked = new int[n];
            parent = _parent;
            children = new List[n];
            Arrays.fill(locked, -1);
            Arrays.setAll(children, i -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                children[_parent[i]].add(i);
            }
        }

        boolean lock(int _num, int _user) {
            if (locked[_num] == -1) {
                locked[_num] = _user;
                return true;
            }
            return false;
        }

        boolean unlock(int _num, int _user) {
            if (locked[_num] == _user) {
                locked[_num] = -1;
                return true;
            }
            return false;
        }

        boolean upgrade(int _num, int _user) {
            int x = _num;
            while (x != -1) {
                if (locked[x] != -1) {
                    return false;
                }
                x = parent[x];
            }
            boolean[] find = new boolean[1];
            dfs(_num, find);
            if (!find[0]) {
                return false;
            }
            locked[_num] = _user;
            return true;
        }

        void dfs(int _x, boolean[] _find) {
            for (int y : children[_x]) {
                if (locked[y] != -1) {
                    locked[y] = -1;
                    _find[0] = true;
                }
                dfs(y, _find);
            }
        }

    }

}
