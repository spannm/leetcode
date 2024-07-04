package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0214 extends LeetcodeProblem {

    String shortestPalindrome(String _s) {
        int[] table = createTable(_s + "#" + new StringBuilder(_s).reverse());

        return new StringBuilder(_s.substring(table[table.length - 1])).reverse() + _s;
    }

    static int[] createTable(String _s) {
        int[] table = new int[_s.length()];
        int index = 0;

        for (int i = 1; i < _s.length(); i++) {
            if (_s.charAt(index) == _s.charAt(i)) {
                table[i] = table[i - 1] + 1;
                index++;
            } else {

                index = table[i - 1];

                while (index > 0 && _s.charAt(index) != _s.charAt(i)) {
                    index = table[index - 1];
                }

                if (_s.charAt(index) == _s.charAt(i)) {
                    index++;
                }
                table[i] = index;
            }
        }
        return table;
    }

}
