class Solution {

    int[] order;
    int index;

    int[] state;
    List<List<Integer>> graph;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        state = new int[numCourses];

        index = numCourses - 1;

        graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        return order;
    }

    private boolean dfs(int course) {
        if (state[course] == 1) return false;
        if (state[course] == 2) return true;

        state[course] = 1;

        for (int next : graph.get(course)) {
            if (!dfs(next)) {
                return false;
            }
        }

        state[course] = 2;
        order[index--] = course;
        return true;
    }
}
