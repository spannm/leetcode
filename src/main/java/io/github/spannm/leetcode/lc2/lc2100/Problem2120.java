package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2120 extends LeetcodeProblem {

    int[] executeInstructions(int _n, int[] _startPos, String _s) {
        int[] ans = new int[_s.length()];
        for (int i = 0; i < _s.length(); i++) {
            int y = _startPos[1];
            int x = _startPos[0];
            int j = i;
            boolean broken = false;
            for (; j < _s.length(); j++) {
                if (_s.charAt(j) == 'R') {
                    if (y + 1 < _n) {
                        y++;
                    } else {
                        ans[i] = j - i;
                        broken = true;
                        break;
                    }
                } else if (_s.charAt(j) == 'L') {
                    if (y - 1 >= 0) {
                        y--;
                    } else {
                        ans[i] = j - i;
                        broken = true;
                        break;
                    }
                } else if (_s.charAt(j) == 'U') {
                    if (x - 1 >= 0) {
                        x--;
                    } else {
                        ans[i] = j - i;
                        broken = true;
                        break;
                    }
                } else if (_s.charAt(j) == 'D') {
                    if (x + 1 < _n) {
                        x++;
                    } else {
                        ans[i] = j - i;
                        broken = true;
                        break;
                    }
                }
            }
            if (!broken) {
                ans[i] = j - i;
            }
        }
        return ans;
    }

}
