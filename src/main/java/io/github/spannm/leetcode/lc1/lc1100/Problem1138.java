package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1138 extends LeetcodeProblem {

    String alphabetBoardPath(String _target) {
        Map<Character, int[]> map = initMap();
        StringBuilder sb = new StringBuilder();
        int[] currPos = new int[2];
        for (char c : _target.toCharArray()) {
            moveToDest(currPos, map.get(c), sb);
        }
        return sb.toString();
    }

    private void moveToDest(int[] _currPos, int[] _dest, StringBuilder _sb) {
        int currRow = _currPos[0];
        int currCol = _currPos[1];
        int destRow = _dest[0];
        int destCol = _dest[1];
        while (currRow != destRow || currCol != destCol) {
            if (currRow < destRow) {
                while (currRow < destRow) {
                    if (currCol != 0 && currRow == 4) {
                        break;
                    }
                    _sb.append("D");
                    currRow++;
                }
                _currPos[0] = currRow;
            }
            if (currRow > destRow) {
                while (currRow > destRow) {
                    _sb.append("U");
                    currRow--;
                }
                _currPos[0] = currRow;
            }
            if (currCol < destCol) {
                while (currCol < destCol) {
                    _sb.append("R");
                    currCol++;
                }
                _currPos[1] = currCol;
            }
            if (currCol > destCol) {
                while (currCol > destCol) {
                    _sb.append("L");
                    currCol--;
                }
                _currPos[1] = currCol;
            }
        }
        _sb.append("!");
    }

    private Map<Character, int[]> initMap() {
        Map<Character, int[]> map = new HashMap<>();
        int row;
        int col;
        int number = 0;
        for (char c = 'a'; c <= 'z'; c++, number++) {
            row = number / 5;
            col = number % 5;
            map.put(c, new int[] {row, col});
        }
        return map;
    }

}
