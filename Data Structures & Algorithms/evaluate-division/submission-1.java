class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0;
                continue;
            }

            result[i] = dfs(graph, new HashSet<>(), src, dst, 1);
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String curr, String target, double product) {
        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            String next = neighbor.getKey();

            if (visited.contains(next)) continue;

            double result = dfs(graph, visited, next, target, product * neighbor.getValue());
            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }
}