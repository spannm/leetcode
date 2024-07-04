package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/boats-to-save-people/">881. Boats to Save People</a>.
 */
class Problem0881 extends LeetcodeProblem {

    /**
     * @param _people weights of people
     * @param _limit maximum weight of one boat
     * @return number of boats required to carry all people
     */
    int numRescueBoats(int[] _people, int _limit) {
        int nbBoats = 0;
        Arrays.sort(_people);

        int left = 0;
        int right = _people.length - 1;

        while (left <= right) {
            int sum = _people[left] + _people[right];
            if (sum <= _limit) {
                // both can get on
                left++;
            } // else: only 1 person (the heavier=left) can get on
            right--;
            nbBoats++;
        }
        return nbBoats;
    }

}
