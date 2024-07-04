package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1061 extends LeetcodeProblem {

    String smallestEquivalentString(String _s1, String _s2, String _baseStr) {
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < _s1.length(); i++) {
            unionFind.union(_s1.charAt(i), _s2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : _baseStr.toCharArray()) {
            sb.append((char) (unionFind.find(c) + 'a'));
        }
        return sb.toString();
    }

    static class UnionFind {
        private final int[] ids;

        UnionFind() {
            ids = new int[26];
            for (int i = 0; i < ids.length; i++) {
                ids[i] = i;
            }
        }

        public void union(char _a, char _b) {
            int x = find(_a);
            int y = find(_b);
            if (x < y) {
                ids[y] = x;
            } else {
                ids[x] = y;
            }
        }

        public int find(char _x) {
            while (_x - 'a' != ids[_x - 'a']) {
                ids[_x - 'a'] = ids[ids[_x - 'a']];
                _x = (char) (ids[_x - 'a'] + 'a');
            }
            return _x - 'a';
        }
    }

}
