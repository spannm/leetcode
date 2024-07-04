package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 927. Three Equal Parts.
 */
class Problem0927 extends LeetcodeProblem {

    int[] threeEqualParts(int[] _arr) {
        int cnt = 0;
        int len = _arr.length;
        for (int v : _arr) {
            cnt += v;
        }
        if (cnt % 3 != 0) {
            return new int[] {-1, -1};
        } else if (cnt == 0) {
            return new int[] {0, len - 1};
        }
        cnt /= 3;

        int i = find(1, _arr);
        int j = find(cnt + 1, _arr);
        int k = find(cnt * 2 + 1, _arr);
        while (k < len && _arr[i] == _arr[j] && _arr[j] == _arr[k]) {
            i++;
            j++;
            k++;
        }
        return k == len ? new int[] {i - 1, j} : new int[] {-1, -1};
    }

    static int find(int _x, int[] _arr) {
        int s = 0;
        for (int i = 0; i < _arr.length; i++) {
            s += _arr[i];
            if (s == _x) {
                return i;
            }
        }
        return 0;
    }

}
