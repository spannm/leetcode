package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 782. Transform to Chessboard.
 */
class Problem0782 extends LeetcodeProblem {

    private int len;

    int movesToChessboard(int[][] _board) {
        len = _board.length;
        int mask = (1 << len) - 1;
        int rowMask = 0;
        int colMask = 0;
        for (int i = 0; i < len; i++) {
            rowMask |= _board[0][i] << i;
            colMask |= _board[i][0] << i;
        }
        int revRowMask = mask ^ rowMask;
        int revColMask = mask ^ colMask;
        int sameRow = 0;
        int sameCol = 0;
        for (int i = 0; i < len; i++) {
            int curRowMask = 0;
            int curColMask = 0;
            for (int j = 0; j < len; j++) {
                curRowMask |= _board[i][j] << j;
                curColMask |= _board[j][i] << j;
            }
            if (curRowMask != rowMask && curRowMask != revRowMask || curColMask != colMask && curColMask != revColMask) {
                return -1;
            }
            sameRow += curRowMask == rowMask ? 1 : 0;
            sameCol += curColMask == colMask ? 1 : 0;
        }
        int t1 = f(rowMask, sameRow);
        int t2 = f(colMask, sameCol);
        return t1 == -1 || t2 == -1 ? -1 : t1 + t2;
    }

    private int f(int _mask, int _count) {
        int ones = Integer.bitCount(_mask);
        if (len % 2 == 1) {
            if (Math.abs(len - ones * 2) != 1 || Math.abs(len - _count * 2) != 1) {
                return -1;
            }
            if (ones == len / 2) {
                return len / 2 - Integer.bitCount(_mask & 0xAAAAAAAA);
            }
            return len / 2 + 1 - Integer.bitCount(_mask & 0x55555555);
        } else {
            if (ones != len / 2 || _count != len / 2) {
                return -1;
            }
            int cnt0 = len / 2 - Integer.bitCount(_mask & 0xAAAAAAAA);
            int cnt1 = len / 2 - Integer.bitCount(_mask & 0x55555555);
            return Math.min(cnt0, cnt1);
        }
    }

}
