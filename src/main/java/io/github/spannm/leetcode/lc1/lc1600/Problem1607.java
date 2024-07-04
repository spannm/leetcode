package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeSqlProblem;

/**
 * 1607. Sellers With No Sales.
 */
public class Problem1607 extends LeetcodeSqlProblem {

    Problem1607() {
        super("""
SELECT seller_name
FROM
Seller
LEFT JOIN Orders USING (seller_id)
GROUP BY seller_id
HAVING IFNULL(SUM(YEAR(sale_date) = 2020), 0) = 0
ORDER BY 1""");
    }

}
