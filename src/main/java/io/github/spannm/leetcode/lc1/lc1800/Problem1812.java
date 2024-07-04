package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1812 extends LeetcodeProblem {

    boolean squareIsWhite(String _coordinates) {
        char x = _coordinates.charAt(0);
        int y = Integer.parseInt(_coordinates.charAt(1) + "");
        return switch (x) {
            case 'a', 'c', 'e', 'g' -> y % 2 == 0;
            default -> y % 2 != 0;
        };
    }

}
