package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0726Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> {1}")
    @CsvSource({"H2O,H2O", "Mg(OH)2, H2MgO2", "K4(ON(SO3)2)2,K4N2O14S4", "(NB3)33,B99N33",
        "((HHe28Be26He)9)34,Be7956H306He8874",
        "((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14,B18900Be18984C4200H5446He1386Li33894N50106O22638"
        })
    void test(String _input, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0726().countOfAtoms(_input));
    }

}
