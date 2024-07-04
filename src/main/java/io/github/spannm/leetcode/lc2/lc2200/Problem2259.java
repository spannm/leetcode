package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Problem2259 extends LeetcodeProblem {

    String removeDigit(String _number, char _digit) {
        StringBuilder sb = new StringBuilder();
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < _number.length(); i++) {
            if (_number.charAt(i) == _digit) {
                sb.append(_number, 0, i);
                sb.append(_number.substring(i + 1));
                nums.add(sb.toString());
                sb.setLength(0);
            }
        }
        nums.sort(Comparator.reverseOrder());
        return nums.get(0);
    }

}
