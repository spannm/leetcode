package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/dota2-senate/">649. Dota2 Senate</a>.
 */
class Problem0649 extends LeetcodeProblem {

    static String predictPartyVictory(String _senate) {
        final int len = _senate.length();
        final Queue<Integer> qRadiant = new LinkedList<>();
        final Queue<Integer> qDire = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (_senate.charAt(i) == 'R') {
                qRadiant.add(i);
            } else {
                qDire.add(i);
            }
        }

        while (!qRadiant.isEmpty() && !qDire.isEmpty()) {
            int iRadiant = qRadiant.poll();
            int iDire = qDire.poll();
            if (iRadiant < iDire) {
                qRadiant.add(iRadiant + len);
            } else {
                qDire.add(iDire + len);
            }
        }

        return qRadiant.size() > qDire.size() ? "Radiant" : "Dire";
    }

}
