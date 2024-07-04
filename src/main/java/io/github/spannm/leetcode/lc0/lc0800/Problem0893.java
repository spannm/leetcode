package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.stream.Collectors;

class Problem0893 extends LeetcodeProblem {

    int numSpecialEquivGroups(String[] _strs) {
        return Arrays.stream(_strs).map(this::getCommonKey).collect(Collectors.toSet()).size();
    }

    private String getCommonKey(String _word) {
        char[] oddIndexed = new char[_word.length() / 2];
        char[] evenIndexed = new char[_word.length() / 2 + (_word.length() % 2 == 0 ? 0 : 1)];
        char[] array = _word.toCharArray();
        for (int i = 0; i < array.length - 1; i += 2) {
            evenIndexed[i / 2] = array[i];
            oddIndexed[i / 2] = array[i + 1];
        }
        if (_word.length() % 2 != 0) {
            evenIndexed[evenIndexed.length - 1] = array[array.length - 1];
        }
        Arrays.sort(oddIndexed);
        Arrays.sort(evenIndexed);
        return new String(evenIndexed) + new String(oddIndexed);
    }

}
