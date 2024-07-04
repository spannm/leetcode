package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1105. Filling Bookcase Shelves.
 */
class Problem1105 extends LeetcodeProblem {

    int minHeightShelves(int[][] _books, int _shelfWidth) {
        int n = _books.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int w = _books[i - 1][0];
            int h = _books[i - 1][1];
            f[i] = f[i - 1] + h;
            for (int j = i - 1; j > 0; j--) {
                w += _books[j - 1][0];
                if (w > _shelfWidth) {
                    break;
                }
                h = Math.max(h, _books[j - 1][1]);
                f[i] = Math.min(f[i], f[j - 1] + h);
            }
        }
        return f[n];
    }

}
