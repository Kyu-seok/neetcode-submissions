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
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                result[i] = -1.0;
                continue;
            }

            result[i] = dfs(graph, new HashSet<String>(), a, b, 1.0);
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String curr, String dest, double product) {
        if (curr.equals(dest)) {
            return product;
        }

        visited.add(curr);

        for (Map.Entry<String, Double> next : graph.get(curr).entrySet()) {
            if (visited.contains(next.getKey())) {
                continue;
            }

            double result = dfs(graph, visited, next.getKey(), dest, product * next.getValue());

            if (result != -1.0) return result;
        }

        return -1.0;
    }
}