package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/validate-stack-sequences/">946. Validate Stack Sequences</a>.
 */
class Problem0946 extends LeetcodeProblem {

    boolean validateStackSequences(final int[] _arrPushed, final int[] _arrPopped) {
        final int[] stack = new int[_arrPushed.length];
        int idxStack = -1;

        int idxPop = 0;
        for (int pushed : _arrPushed) {
            stack[++idxStack] = pushed; // push
            while (idxStack >= 0 && stack[idxStack] == _arrPopped[idxPop]) {
                idxStack--; // pop
                idxPop++;
            }
        }
        return idxStack < 0;
    }

}
