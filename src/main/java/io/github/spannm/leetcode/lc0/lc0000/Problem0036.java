package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Sudoku;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku/">36. Valid Sudoku</a>.
 */
class Problem0036 extends LeetcodeProblem {

    boolean isValidSudoku(char[][] _board) {
        try {
            new Sudoku.Board(getClass().getSimpleName(), _board);
            return true;
        } catch (Exception _ex) {
            return false;
        }
    }

}
