class Solution {
    int[] state;
    List<List<Integer>> graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.state = new int[numCourses];
        this.graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canTake(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean canTake(int course) {
        if (state[course] == 1) return false;
        if (state[course] == 2) return true;

        // mark visiting
        state[course] = 1;        

        List<Integer> nextCourses = graph.get(course);

        for (int next : nextCourses) {
            if (!canTake(next)) {
                return false;
            }
        }

        state[course] = 2;
        return true;
    }
}
