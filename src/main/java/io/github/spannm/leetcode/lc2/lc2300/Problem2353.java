package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/design-a-food-rating-system/">2353. Design a Food Rating System</a>.
 */
class Problem2353 extends LeetcodeProblem {

    static class FoodRatings {

        private final Map<String, SortedSet<Food>> foodsByCuisine = new HashMap<>();
        private final Map<String, Food>            foodsByName    = new HashMap<>();

        FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodsByCuisine.computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> b.rating == a.rating ? a.name.compareTo(b.name) : b.rating - a.rating)).add(food);
                foodsByName.put(foods[i], food);
            }
        }

        void changeRating(String _food, int _newRating) {
            Food food = foodsByName.get(_food);
            Set<Food> foods = foodsByCuisine.get(food.cuisine);
            foods.remove(food);
            food.rating = _newRating;
            foods.add(food);
        }

        String highestRated(String _cuisine) {
            return foodsByCuisine.get(_cuisine).first().name;
        }

        static class Food {
            private final String name;
            private final String cuisine;
            private int          rating;

            Food(String _name, String _cuisine, int _rating) {
                name = _name;
                cuisine = _cuisine;
                rating = _rating;
            }
        }

    }

}
