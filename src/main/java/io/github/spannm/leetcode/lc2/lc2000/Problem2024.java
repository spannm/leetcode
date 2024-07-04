package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">2024. Maximize the Confusion of an
 * Exam</a>.
 */
class Problem2024 extends LeetcodeProblem {

    int maxConsecutiveAnswers(final String _answerKey, final int _k) {
        return Math.max(helper(_answerKey, _k, 'F'), helper(_answerKey, _k, 'T'));
    }

    int helper(final String _answerKey, int _k, final char _letter) {
        int max = 0;
        int count = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < _answerKey.length(); i++) {
            if (_answerKey.charAt(i) == _letter) {
                count++;
            } else if (_k > 0) {
                q.add(i);
                _k--;
                count++;
            } else {
                q.add(i);
                max = Math.max(count, max);
                int firstEncountered = q.removeFirst();
                count = i - firstEncountered;
            }
        }
        return Math.max(count, max);
    }

}
