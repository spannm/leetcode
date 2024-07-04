package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1279 extends LeetcodeProblem {

    static class TrafficLight {
        private int road = 1;

        public synchronized void carArrived(int _carId, int _roadId, int _direction, Runnable _turnGreen, Runnable _crossCar) {
            if (_roadId != road) {
                _turnGreen.run();
                road = _roadId;
            }
            _crossCar.run();
        }

    }

}
