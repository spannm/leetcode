package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1058. Minimize Rounding Error to Meet Target.
 */
class Problem1058 extends LeetcodeProblem {

    String minimizeError(String[] _prices, int _target) {
        int mi = 0;
        List<Double> arr = new ArrayList<>();
        for (String p : _prices) {
            double price = Double.parseDouble(p);
            mi += (int) price;
            double d = price - (int) price;
            if (d > 0) {
                arr.add(d);
            }
        }
        if (_target < mi || _target > mi + arr.size()) {
            return "-1";
        }
        int d = _target - mi;
        arr.sort(Comparator.reverseOrder());
        double ans = d;
        for (int i = 0; i < d; i++) {
            ans -= arr.get(i);
        }
        for (int i = d; i < arr.size(); i++) {
            ans += arr.get(i);
        }
        DecimalFormat df = new DecimalFormat("#0.000");
        return df.format(ans);
    }

}
