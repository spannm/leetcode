package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1333. Filter Restaurants by Vegan-Friendly, Price and Distance
 * <p>
 * Given the array restaurants where restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]. You have to
 * filter the restaurants using three filters. The veganFriendly filter will be either true (meaning you should only
 * include restaurants with veganFriendlyi set to true) or false (meaning you can include any restaurant). In addition,
 * you have the filters maxPrice and maxDistance which are the maximum value for price and distance of restaurants you
 * should consider respectively. Return the array of restaurant IDs after filtering, ordered by rating from highest to
 * lowest. For restaurants with the same rating, order them by id from highest to lowest. For simplicity veganFriendlyi
 * and veganFriendly take value 1 when it is true, and 0 when it is false.
 * <p>
 * Example 1: Input: restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly =
 * 1, maxPrice = 50, maxDistance = 10 Output: [3,1,5] Explanation: The restaurants are: Restaurant 1 [id=1, rating=4,
 * veganFriendly=1, price=40, distance=10] Restaurant 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
 * Restaurant 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4] Restaurant 4 [id=4, rating=10, veganFriendly=0,
 * price=10, distance=3] Restaurant 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1] After filter restaurants
 * with veganFriendly = 1, maxPrice = 50 and maxDistance = 10 we have restaurant 3, restaurant 1 and restaurant 5
 * (ordered by rating from highest to lowest).
 * <p>
 * Example 2: Input: restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly =
 * 0, maxPrice = 50, maxDistance = 10 Output: [4,3,2,1,5] Explanation: The restaurants are the same as in example 1, but
 * in this case the filter veganFriendly = 0, therefore all restaurants are considered.
 * <p>
 * Example 3: Input: restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly =
 * 0, maxPrice = 30, maxDistance = 3 Output: [4,5]
 * <p>
 * Constraints: 1 <= restaurants.length <= 10^4 restaurants[i].length == 5 1 <= idi, ratingi, pricei, distancei <= 10^5
 * 1 <= maxPrice, maxDistance <= 10^5 veganFriendlyi and veganFriendly are 0 or 1. All idi are distinct.
 */
class Problem1333 extends LeetcodeProblem {

    List<Integer> filterRestaurants(int[][] _restaurants, int _veganFriendly, int _maxPrice, int _maxDistance) {
        List<int[]> list = new ArrayList<>();
        for (int[] restaurant : _restaurants) {
            if ((_veganFriendly == 1 && restaurant[2] == 1 || _veganFriendly == 0)
                && restaurant[3] <= _maxPrice && restaurant[4] <= _maxDistance) {
                list.add(restaurant);
            }
        }
        list.sort((a, b) -> b[1] - a[1] == 0 ? b[0] - a[0] : b[1] - a[1]);
        return list.stream().map(restaurant -> restaurant[0]).collect(Collectors.toList());
    }

}
