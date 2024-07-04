package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/asteroid-collision/">735. Asteroid Collision</a>.
 */
class Problem0735 extends LeetcodeProblem {

    int[] asteroidCollision(int[] _asteroids) {
        int idx = -1; // index of well-placed asteroids
        OUTER: for (int a : _asteroids) {
            if (a < 0) {
                while (idx >= 0 && _asteroids[idx] > 0) {
                    if (_asteroids[idx] > -a || _asteroids[idx--] == -a) {
                        continue OUTER;
                    }
                }
            }
            _asteroids[++idx] = a;
        }
        int[] result = Arrays.copyOfRange(_asteroids, 0, idx + 1);
        _asteroids = null;
        return result;
    }

}
