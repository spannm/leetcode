package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1880 extends LeetcodeProblem {

    boolean isSumEqual(String _firstWord, String _secondWord, String _targetWord) {
        StringBuilder sb = new StringBuilder();
        int a = getSum(_firstWord, sb);
        sb.setLength(0);
        int b = getSum(_secondWord, sb);
        sb.setLength(0);
        int c = getSum(_targetWord, sb);
        return a + b == c;
    }

    private int getSum(String _firstWord, StringBuilder _sb) {
        for (char c : _firstWord.toCharArray()) {
            _sb.append(c - 'a');
        }
        return Integer.parseInt(_sb.toString());
    }

}
