class Solution {
    List<List<Integer>> graph;
    int[] state;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.graph = new ArrayList<>();
        this.state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(list, i)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];

        for (int i = 0, n = list.size() - 1; i < list.size(); i++) {
            result[i] = list.get(n - i);
        }

        return result;
    }

    private boolean dfs(List<Integer> list, int course) {
        if (state[course] == 1) return false;
        if (state[course] == 2) return true;

        state[course] = 1;

        List<Integer> nextList = graph.get(course);

        for (int next : nextList) {
            if (!dfs(list, next)) {
                return false;
            }
        }

        state[course] = 2;
        list.add(course);

        return true;
    }
}
