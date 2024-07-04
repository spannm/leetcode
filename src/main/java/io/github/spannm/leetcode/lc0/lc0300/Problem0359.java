package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0359 extends LeetcodeProblem {

    static class Logger {

        private final Map<String, Integer> map;

        Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int _timestamp, String _message) {
            map.putIfAbsent(_message, _timestamp);
            if (map.putIfAbsent(_message, _timestamp) == null) {
                return true;
            } else {
                if (_timestamp - map.get(_message) < 10) {
                    return false;
                } else {
                    map.put(_message, _timestamp);
                    return true;
                }
            }
        }
    }

}
