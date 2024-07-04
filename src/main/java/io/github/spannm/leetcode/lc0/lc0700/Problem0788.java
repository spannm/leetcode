package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.stream.IntStream;

class Problem0788 extends LeetcodeProblem {

    int rotatedDigits(int _n) {
        Map<Character, String> map = Map.of(
            '0', "0",
            '1', "1",
            '8', "8",
            '2', "5",
            '5', "2",
            '6', "9",
            '9', "6");
        return (int) IntStream.rangeClosed(1, _n).filter(i -> isRotatedNumber(i, map)).count();
    }

    static boolean isRotatedNumber(int _num, Map<Character, String> _map) {
        String origNum = String.valueOf(_num);
        StringBuilder sb = new StringBuilder();
        for (char c : String.valueOf(_num).toCharArray()) {
            String val = _map.get(c);
            if (val == null) {
                return false;
            } else {
                sb.append(val);
            }
        }
        return !origNum.contentEquals(sb);
    }

}
