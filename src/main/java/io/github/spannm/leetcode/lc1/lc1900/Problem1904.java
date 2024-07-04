package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1904 extends LeetcodeProblem {

    int numberOfRounds(String _startTime, String _finishTime) {
        int rounds = 0;
        int startHour = Integer.parseInt(_startTime.split(":")[0]);
        int endHour = Integer.parseInt(_finishTime.split(":")[0]);
        int startMin = Integer.parseInt(_startTime.split(":")[1]);
        int endMin = Integer.parseInt(_finishTime.split(":")[1]);
        if (endHour < startHour) {
            endHour += 24;
        } else if (endHour == startHour && endMin < startMin) {
            endHour += 24;
        }
        if (startHour == endHour) {
            if (startMin == 0 && endMin >= 15) {
                rounds++;
            }
            if (startMin <= 15 && endMin >= 30) {
                rounds++;
            }
            if (startMin <= 30 && endMin >= 45) {
                rounds++;
            }
        } else {

            if (startMin == 0) {
                rounds += 4;
            } else if (startMin <= 15) {
                rounds += 3;
            } else if (startMin <= 30) {
                rounds += 2;
            } else if (startMin <= 45) {
                rounds++;
            }

            if (endMin >= 45) {
                rounds += 3;
            } else if (endMin >= 30) {
                rounds += 2;
            } else if (endMin >= 15) {
                rounds++;
            }

            rounds += (endHour - startHour - 1) * 4;
        }
        return rounds;
    }

}
