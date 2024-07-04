package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2728. Count Houses in a Circular Street.
 */
class Problem2728 extends LeetcodeProblem {

    int houseCount(Street _street, int k) {
        while (k-- > 0) {
            _street.openDoor();
            _street.moveLeft();
        }
        int ans = 0;
        while (_street.isDoorOpen()) {
            ans++;
            _street.closeDoor();
            _street.moveLeft();
        }
        return ans;
    }

    @SuppressWarnings({"PMD.ClassNamingConventions", "checkstyle:TypeNameCheck"})
    interface Street {
        void openDoor();

        void closeDoor();

        boolean isDoorOpen();

        void moveRight();

        void moveLeft();
    }

}
