package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2590 extends LeetcodeProblem {

    static class Task {
        private final int         taskId;
        private final String      taskName;
        private final int         dueDate;
        private final Set<String> tags;
        private boolean           finish;

        Task(int _taskId, String _taskName, int _dueDate, Set<String> _tags) {
            taskId = _taskId;
            taskName = _taskName;
            dueDate = _dueDate;
            tags = _tags;
        }

    }

    static class TodoList {
        private int                               taskId = 1;
        private final Map<Integer, TreeSet<Task>> tasks  = new HashMap<>();

        int addTask(int _userId, String _taskDescription, int _dueDate, List<String> _tags) {
            Task task = new Task(taskId++, _taskDescription, _dueDate, new HashSet<>(_tags));
            tasks.computeIfAbsent(_userId, k -> new TreeSet<>(Comparator.comparingInt(a -> a.dueDate))).add(task);
            return task.taskId;
        }

        List<String> getAllTasks(int _userId) {
            List<String> ans = new ArrayList<>();
            if (tasks.containsKey(_userId)) {
                for (Task task : tasks.get(_userId)) {
                    if (!task.finish) {
                        ans.add(task.taskName);
                    }
                }
            }
            return ans;
        }

        List<String> getTasksForTag(int _userId, String _tag) {
            List<String> ans = new ArrayList<>();
            if (tasks.containsKey(_userId)) {
                for (Task task : tasks.get(_userId)) {
                    if (task.tags.contains(_tag) && !task.finish) {
                        ans.add(task.taskName);
                    }
                }
            }
            return ans;
        }

        void completeTask(int _userId, int _taskId) {
            if (tasks.containsKey(_userId)) {
                for (Task task : tasks.get(_userId)) {
                    if (task.taskId == _taskId) {
                        task.finish = true;
                        break;
                    }
                }
            }
        }

    }

}
