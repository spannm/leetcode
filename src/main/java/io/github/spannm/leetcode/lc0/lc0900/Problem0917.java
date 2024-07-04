package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0917 extends LeetcodeProblem {

    String reverseOnlyLetters(String _s) {
        char[] arr = _s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j;) {
            if (Character.isLetter(arr[i]) && Character.isLetter(arr[j])) {
                char temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            } else if (Character.isLetter(arr[i])) {
                j--;
            } else if (Character.isLetter(arr[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(arr);
    }

}
