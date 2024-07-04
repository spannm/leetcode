package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/text-justification/">68. Text Justification</a>.
 */
class Problem0068 extends LeetcodeProblem {

    List<String> fullJustify(String[] _words, final int _maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        lines.add(new ArrayList<>());
        List<String> currLine = lines.get(0);
        int availWidth = _maxWidth;
        List<String> output = new ArrayList<>();

        final int wordCount = _words.length;

        for (int w = 0; w < wordCount; w++) {
            String word = _words[w];
            int wordLen = currLine.isEmpty() ? word.length() : word.length() + 1;
            if (currLine.isEmpty() || wordLen <= availWidth) {
                currLine.add(word);
                availWidth -= wordLen;
            } else {
                // line full

                // add current line, distribute availWidth spaces evenly
                int lineWordCount = currLine.size();
                if (lineWordCount == 1) {
                    output.add(currLine.get(0) + " ".repeat(availWidth));
                } else {
                    availWidth = availWidth + lineWordCount - 1;
                    int spaceCount = availWidth / (lineWordCount - 1);
                    int spaceRemain = availWidth % (lineWordCount - 1);
                    String line = currLine.get(0);
                    for (int c = 1; c < lineWordCount; c++) {
                        line += " ".repeat(spaceCount);
                        if (spaceRemain > 0) {
                            line += " ";
                            spaceRemain--;
                        }
                        line += currLine.get(c);
                    }
                    output.add(line);
                }

                // start next line
                currLine = new ArrayList<>();
                lines.add(currLine);
                currLine.add(word);
                availWidth = _maxWidth - word.length();
            }

            if (w == wordCount - 1) { // last
                // add last line with right padding
                output.add(String.join(" ", currLine) + " ".repeat(availWidth));
            }

        }

        return output;
    }

}
