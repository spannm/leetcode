package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/smallest-sufficient-team/">1125. Smallest Sufficient Team</a>.
 */
class Problem1125 extends LeetcodeProblem {

    int[] smallestSufficientTeam(final String[] _reqSkills, final List<List<String>> _candidates) {
        final Map<String, Integer> skillsMap = new LinkedHashMap<>();
        int skillIndex = 0;
        for (String skill : _reqSkills) {
            skillsMap.put(skill, skillIndex++);
        }
        int reqSkillsMask = (1 << skillIndex) - 1;

        final int nbCandidates = _candidates.size();
        int[] candidateSkills = new int[nbCandidates];
        for (int i1 = 0; i1 < nbCandidates; i1++) {
            for (String skill1 : _candidates.get(i1)) {
                candidateSkills[i1] |= 1 << skillsMap.get(skill1);
            }
        }

        final List<Integer> mainTeam = new ArrayList<>();

        findTeam(reqSkillsMask, candidateSkills, 0, 0, new ArrayList<>(), mainTeam);

        return mainTeam.stream().mapToInt(i -> i).toArray();
    }

    private static void findTeam(final int _reqSkillsMask, final int[] _candidatesSkills, final int _teamSkills,
        final int _personIndex, final List<Integer> _localTeam, final List<Integer> _mainTeam) {

        if (!_mainTeam.isEmpty() && _localTeam.size() >= _mainTeam.size() - 1 || _personIndex == _candidatesSkills.length) {
            return;
        }
        _localTeam.add(_personIndex);
        if ((_teamSkills | _candidatesSkills[_personIndex]) == _reqSkillsMask) {
            _mainTeam.clear();
            _mainTeam.addAll(_localTeam);
            _localTeam.remove(_localTeam.size() - 1);
            return;
        } else if ((_teamSkills | _candidatesSkills[_personIndex]) > _teamSkills) {
            findTeam(_reqSkillsMask, _candidatesSkills, _teamSkills | _candidatesSkills[_personIndex], _personIndex + 1, _localTeam, _mainTeam);
        }
        _localTeam.remove(_localTeam.size() - 1);
        findTeam(_reqSkillsMask, _candidatesSkills, _teamSkills, _personIndex + 1, _localTeam, _mainTeam);
    }

}
