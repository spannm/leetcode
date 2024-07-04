package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">6. Zigzag Conversion</a>.
 */
class Problem0006 extends LeetcodeProblem {

    String convert(String _s, int _numRows) {
        if (_numRows <= 1) {
            return _s;
        }

        final char[] arr = _s.toCharArray();
        boolean up = true;
        int z = 0;
        List<StringBuilder> sbs = IntStream.range(0, _numRows).mapToObj(x -> new StringBuilder()).toList();

        for (int i = 0; i < arr.length; i++) {
            sbs.get(z).append(arr[i]);
            if (up) {
                z++;
            } else {
                z--;
            }
            if (z == 0 || z == _numRows - 1) {
                up = !up;
            }
        }

        return sbs.stream().map(StringBuilder::toString).collect(Collectors.joining(""));
    }

}
