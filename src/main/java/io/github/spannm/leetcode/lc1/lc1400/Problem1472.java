package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/design-browser-history/">1472. Design Browser History</a>.
 */
class Problem1472 extends LeetcodeProblem {

    static class BrowserHistory {
        private List<String> history = new ArrayList<>();
        private int          index   = -1;

        BrowserHistory(String _homepage) {
            Objects.requireNonNull(_homepage, "Home page required");
            history.add(_homepage);
            index = 0;
        }

        /**
         * Visits {@code url} from the current page. It clears up all the forward history.
         *
         * @param _url url
         */
        public void visit(String _url) {
            history = history.subList(0, index + 1);
            history.add(_url);
            index++;
        }

        /**
         * Moves {@code steps} back in history.<br>
         * If you can only return {@code x} steps in the history and {@code steps &gt; x}, you will return only
         * {@code x} steps.<br>
         * Return the current url after moving back in history at most steps.
         *
         * @param _steps number of steps
         * @return current url after backward movement
         */
        public String back(int _steps) {
            index = Math.max(0, index - _steps);
            return history.get(index);
        }

        public String forward(int _steps) {
            index = Math.min(history.size() - 1, index + _steps);
            return history.get(index);
        }

        @Override
        public String toString() {
            return String.format("%s[current=%s, history=%s, index=%s]",
                getClass().getSimpleName(), history.get(index), history, index);
        }

    }

}
