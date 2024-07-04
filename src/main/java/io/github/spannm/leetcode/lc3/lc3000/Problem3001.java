package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3001. Minimum Moves to Capture The Queen.
 */
class Problem3001 extends LeetcodeProblem {

    int minMovesToCaptureTheQueen(int _a, int _b, int _c, int _d, int _e, int _f) {
        int[] dirs1 = {-1, 0, 1, 0, -1};
        int[] dirs2 = {-1, 1, 1, -1, -1};
        return check(dirs1, _a, _b, _c, _d, _e, _f) || check(dirs2, _c, _d, _a, _b, _e, _f) ? 1 : 2;
    }

    static boolean check(int[] _dirs, int _sx, int _sy, int _bx, int _by, int _e, int _f) {
        for (int d = 0; d < 4; d++) {
            for (int k = 1; k < 8; k++) {
                int x = _sx + _dirs[d] * k;
                int y = _sy + _dirs[d + 1] * k;
                if (x < 1 || x > 8 || y < 1 || y > 8 || x == _bx && y == _by) {
                    break;
                }
                if (x == _e && y == _f) {
                    return true;
                }
            }
        }
        return false;
    }

}
