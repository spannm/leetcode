package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/">212. Word Search II.</a>.
 */
class Problem0212 extends LeetcodeProblem {

    private char[][]          board;
    private int               nbRows;
    private int               nbCols;
    private String[]          words;
    private final Set<String> result = new TreeSet<>();

    List<String> findWords(char[][] _board, String[] _words) {
        board = _board;
        words = _words;
        nbRows = _board.length;
        nbCols = _board[0].length;
        Trie tree = new Trie();
        for (int i = 0; i < _words.length; i++) {
            tree.insert(_words[i], i);
        }
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                dfs(tree, r, c);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(Trie _trieNode, int _r, int _c) {
        int idx = board[_r][_c] - 'a';
        if (_trieNode.getChildren()[idx] == null) {
            return;
        }
        _trieNode = _trieNode.getChildren()[idx];
        if (_trieNode.getRef() != -1) {
            result.add(words[_trieNode.getRef()]);
            _trieNode.setRef(-1);
        }
        char c = board[_r][_c];
        board[_r][_c] = '#';
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = _r + dirs[k];
            int y = _c + dirs[k + 1];
            if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && board[x][y] != '#') {
                dfs(_trieNode, x, y);
            }
        }
        board[_r][_c] = c;
    }

    static class Trie {
        private final Trie[] children = new Trie[26];
        private int          ref      = -1;

        int getRef() {
            return ref;
        }

        void setRef(int _ref) {
            ref = _ref;
        }

        Trie[] getChildren() {
            return children;
        }

        void insert(String _word, int _ref) {
            Trie node = this;
            for (char c : _word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new Trie();
                }
                node = node.children[i];
            }
            node.ref = _ref;
        }

    }

}
