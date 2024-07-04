package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1344 extends LeetcodeProblem {

    double angleClock(int _hour, int _minutes) {
        double minAngle = _minutes * 360 / 60;
        double hourAnglePart1 = _hour != 12 ? _hour * 360 / 12 : 0;
        double hourAnglePart2 = (30 * _minutes) / 60D;
        double hourAngle = hourAnglePart1 + hourAnglePart2;
        double preResult = Math.abs(minAngle - hourAngle);
        return preResult > 180 ? 360 - preResult : preResult;
    }

}
