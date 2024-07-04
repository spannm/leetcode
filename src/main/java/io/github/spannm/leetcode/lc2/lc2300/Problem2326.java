package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

class Problem2326 extends LeetcodeProblem {

    int[][] spiralMatrix(int _m, int _n, ListNode _head) {
        List<Integer> list = new ArrayList<>();
        while (_head != null) {
            list.add(_head.val);
            _head = _head.next;
        }
        int[][] matrix = new int[_m][_n];
        int i = 0;
        int j = 0;
        int index = 0;
        int rightBorder = _n - 1;
        int bottom = _m - 1;
        int leftBorder = 0;
        int top = 1;
        int count = 0;
        while (index < _m * _n) {
            // go right
            while (j <= rightBorder) {
                matrix[i][j++] = index < list.size() ? list.get(index++) : -1;
                count++;
            }
            if (count >= _m * _n) {
                return matrix;
            }
            rightBorder--;
            j--;

            // go down
            i++;
            while (i <= bottom) {
                matrix[i++][j] = index < list.size() ? list.get(index++) : -1;
                count++;
            }
            if (count >= _m * _n) {
                return matrix;
            }
            i--;
            bottom--;

            // go left
            j--;
            while (j >= leftBorder) {
                matrix[i][j--] = index < list.size() ? list.get(index++) : -1;
                count++;
            }
            if (count >= _m * _n) {
                return matrix;
            }
            j++;
            leftBorder++;

            // go top
            i--;
            while (i >= top) {
                matrix[i--][j] = index < list.size() ? list.get(index++) : -1;
                count++;
            }
            if (count >= _m * _n) {
                return matrix;
            }
            i++;
            top++;
            j++;
        }
        return matrix;
    }

}
