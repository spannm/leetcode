package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1169. Invalid Transactions.
 */
class Problem1169 extends LeetcodeProblem {

    List<String> invalidTransactions(String[] _transactions) {
        Map<String, List<Item>> d = new HashMap<>();
        Set<Integer> idx = new HashSet<>();
        for (int i = 0; i < _transactions.length; i++) {
            var e = _transactions[i].split(",");
            String name = e[0];
            int time = Integer.parseInt(e[1]);
            int amount = Integer.parseInt(e[2]);
            String city = e[3];
            d.computeIfAbsent(name, k -> new ArrayList<>()).add(new Item(time, city, i));
            if (amount > 1000) {
                idx.add(i);
            }
            for (Item item : d.get(name)) {
                if (!city.equals(item.city) && Math.abs(time - item.t) <= 60) {
                    idx.add(i);
                    idx.add(item.i);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i : idx) {
            ans.add(_transactions[i]);
        }
        return ans;
    }

    static class Item {
        private final int    t;
        private final String city;
        private final int    i;

        Item(int _t, String _city, int _i) {
            t = _t;
            city = _city;
            i = _i;
        }

    }

}
