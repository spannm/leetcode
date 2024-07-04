package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Sudoku;

/**
 * <a href="https://leetcode.com/problems/sudoku-solver/">37. Sudoku Solver</a>.
 * <p>
 * See <a href="https://www.sudokuwiki.org/sudoku.htm">Instructions</a>.
 */
class Problem0037 extends LeetcodeProblem {

    void solveSudoku(char[][] _board) {
        Sudoku.Solver solver = new Sudoku.Solver(true);

        Sudoku.Board b = new Sudoku.Board(getClass().getSimpleName(), _board);
        solver.solve(b);
        b.updateBoardMatrix(_board);
    }

}
