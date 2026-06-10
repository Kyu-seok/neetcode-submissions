class Solution {

    List<Set<Integer>> graph;
    int[] state;
    int[] order;
    int index;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        state = new int[numCourses];
        order = new int[numCourses];
        index = numCourses - 1;

        // Build graph
        graph = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] p : prerequisites) {
            int prereq = p[0];
            int course = p[1];

            graph.get(prereq).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }

        for (int i = numCourses - 1; i >= 0; i--) {
            int course = order[i];

            Set<Integer> nexts = new HashSet<>(graph.get(course));

            for (int next : nexts) {
                graph.get(course).addAll(graph.get(next));
            }
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] q : queries) {
            int prereq = q[0];
            int course = q[1];

            boolean result = graph.get(prereq).contains(course);
            answer.add(result);
        }

        return answer;
    }

    private boolean dfs(int course) {
        if (state[course] == 1) return false;
        if (state[course] == 2) return true;

        state[course] = 1;

        for (int next : graph.get(course)) {
            dfs(next);
        }

        state[course] = 2;
        order[index--] = course;
        return true;
    }
}