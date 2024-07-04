package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0875Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], target {1} hours --> {2}/hour")
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 1; -1", // not possible
        "5; 5; 1", // one pile
        "5; 4; 2", // one pile
        "5; 3; 2", // one pile
        "5; 2; 3", // one pile
        "3,6,7,11; 8; 4",
        "30,11,23,4,20; 5; 30",
        "30,11,23,4,20; 6; 23",
        "332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,"
        + "877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184; 823855818; 14",
        "190593446,46966570,58112906,718695514,467956628,32868367,774795598,866489925,99515980,403797587,236552660,"
        + "791498323,261642291,421618193,656016520,735154815,42473162,17218552,130422486,610624004,263684205,"
        + "274273276,86320038,191161325,144782805,606503472,137683203,123723979,313447910,807728967,795901753,"
        + "535110917,818848819,375034713,390935126,702086996,746196272,288093628,674659573,379407501,517196534,"
        + "977676916,916154034,275038047,411849904,105284895,310478426,715812144,481088151,400006951,193276729,"
        + "23673830,622253684,332587451,287931061,65207733,505132344,572989906; 532200648; 45"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _piles,
        int _hours,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0875().minEatingSpeed(_piles, _hours));
    }

}
