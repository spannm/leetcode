package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1166 extends LeetcodeProblem {

    static class Trie {
        private final Map<String, Trie> children = new HashMap<>();
        private final int               v;

        Trie(int _v) {
            v = _v;
        }

        boolean insert(String _w, int _v) {
            Trie node = this;
            String[] ps = _w.split("/");
            for (int i = 1; i < ps.length - 1; i++) {
                var p = ps[i];
                if (!node.children.containsKey(p)) {
                    return false;
                }
                node = node.children.get(p);
            }
            if (node.children.containsKey(ps[ps.length - 1])) {
                return false;
            }
            node.children.put(ps[ps.length - 1], new Trie(_v));
            return true;
        }

        int search(String _w) {
            Trie node = this;
            var ps = _w.split("/");
            for (int i = 1; i < ps.length; i++) {
                var p = ps[i];
                if (!node.children.containsKey(p)) {
                    return -1;
                }
                node = node.children.get(p);
            }
            return node.v;
        }

    }

    static class FileSystem {
        private final Trie trie = new Trie(-1);

        FileSystem() {
        }

        boolean createPath(String _path, int _value) {
            return trie.insert(_path, _value);
        }

        int get(String _path) {
            return trie.search(_path);
        }

    }

}
