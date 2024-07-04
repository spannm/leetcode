package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1826 extends LeetcodeProblem {

    int badSensor(int[] _sensor1, int[] _sensor2) {

        int i = 0;
        int j = 0;
        while (i < _sensor1.length && j < _sensor2.length - 1) {
            if (_sensor1[i] != _sensor2[j]) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        boolean sensor2Faulty = j == _sensor2.length - 1 && i == _sensor1.length;

        i = 0;
        j = 0;
        while (i < _sensor1.length - 1 && j < _sensor2.length) {
            if (_sensor1[i] == _sensor2[j]) {
                i++;
            }
            j++;
        }
        boolean sensor1Faulty = i == _sensor1.length - 1 && j == _sensor2.length;
        if (sensor1Faulty && sensor2Faulty) {
            return -1;
        } else if (sensor1Faulty) {
            return 1;
        } else if (sensor2Faulty) {
            return 2;
        }
        return -1;
    }

}
