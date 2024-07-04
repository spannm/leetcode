package io.github.spannm.leetcode.lc0.lc0500;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0599Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "Shogun,Tapioca Express,Burger King,KFC]; Piatti,The Grill at Torrey Pines,Hungry Hunter Steakhouse,Shogun; Shogun",
        "Shogun,Tapioca Express,Burger King,KFC]; KFC,Shogun,Burger King; Shogun",
        "happy,sad,good; sad,happy,good; sad,happy"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _list1,
        @ConvertWith(CsvToStringArray.class) String[] _list2,
        @ConvertWith(CsvToStringArray.class) String[] _expectedResult) {
        String[] result = new Problem0599().findRestaurant(_list1, _list2);
        assertThat(result).containsExactlyInAnyOrder(_expectedResult);
    }

}
