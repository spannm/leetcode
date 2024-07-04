package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem2043 extends LeetcodeProblem {
    static class Bank {

        private final List<Long> list;

        Bank(long[] _balance) {
            list = new ArrayList<>();
            for (long b : _balance) {
                list.add(b);
            }
        }

        public boolean transfer(int _account1, int _account2, long _money) {
            if (_account1 - 1 >= list.size()) {
                return false;
            } else if (list.get(_account1 - 1) < _money) {
                return false;
            } else if (_account2 - 1 >= list.size()) {
                return false;
            } else {
                Long original = list.remove(_account1 - 1);
                list.add(_account1 - 1, original - _money);
                Long remove = list.remove(_account2 - 1);
                list.add(_account2 - 1, remove + _money);
                return true;
            }
        }

        public boolean deposit(int _account, long _money) {
            if (_account - 1 >= list.size()) {
                return false;
            } else {
                Long original = list.remove(_account - 1);
                list.add(_account - 1, original + _money);
                return true;
            }
        }

        public boolean withdraw(int _account, long _money) {
            if (_account - 1 >= list.size()) {
                return false;
            } else if (list.get(_account - 1) < _money) {
                return false;
            } else {
                Long original = list.remove(_account - 1);
                list.add(_account - 1, original - _money);
                return true;
            }
        }
    }

}
