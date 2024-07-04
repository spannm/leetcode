package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1576 extends LeetcodeProblem {

    String modifyString(String _s) {
        char[] arr = _s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 3; j++) {
                    if (i > 0 && arr[i - 1] == 'a' + j) {
                        continue;
                    } else if (i < arr.length - 1 && arr[i + 1] == 'a' + j) {
                        continue;
                    } else {
                        arr[i] = (char) ('a' + j);
                        break;
                    }
                }
            }
        }
        return String.valueOf(arr);
    }

}
