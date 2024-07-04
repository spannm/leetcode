package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1620 extends LeetcodeProblem {

    static int[] bestCoordinate(int[][] _towers, int _radius) {
        int maxSignal = 0;
        int[] best = new int[2];
        for (int[] tower : _towers) {
            int thisQuality = 0;
            for (int[] tower2 : _towers) {
                double distance = Math.sqrt((tower[0] - tower2[0]) * (tower[0] - tower2[0]) + (tower[1] - tower2[1]) * (tower[1] - tower2[1]));
                if (distance <= _radius) {
                    thisQuality += Math.floor(tower2[2] / (1 + distance));
                }
            }
            if (thisQuality > maxSignal) {
                maxSignal = thisQuality;
                best[0] = tower[0];
                best[1] = tower[1];
            } else if (thisQuality == maxSignal) {
                if (tower[0] < best[0]) {
                    best[0] = tower[0];
                    best[1] = tower[1];
                } else if (tower[0] == best[0] && tower[1] < best[1]) {
                    best[0] = tower[0];
                    best[1] = tower[1];
                }
            }
        }
        return best;
    }

}
