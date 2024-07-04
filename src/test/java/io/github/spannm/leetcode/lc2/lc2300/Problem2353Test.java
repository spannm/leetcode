package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc2.lc2300.Problem2353.FoodRatings;
import org.junit.jupiter.api.Test;

class Problem2353Test extends LeetcodeBaseTest {

    @Test
    void test1() {
        FoodRatings foodRatings = new FoodRatings(
            new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
            new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"},
            new int[] {9, 12, 8, 15, 14, 7});

        assertEquals("kimchi", foodRatings.highestRated("korean"));
        // "kimchi" is the highest rated korean food with a rating of 9.

        assertEquals("ramen", foodRatings.highestRated("japanese"));
        // "ramen" is the highest rated japanese food with a rating of 14.

        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.

        assertEquals("sushi", foodRatings.highestRated("japanese"));
        // "sushi" is the highest rated japanese food with a rating of 16.

        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        assertEquals("ramen", foodRatings.highestRated("japanese"));
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }

}
