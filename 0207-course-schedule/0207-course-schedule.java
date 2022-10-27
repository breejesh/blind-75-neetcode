class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        for (int i = 0; i < numCourses; i++) {
            graph.addNode(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.addEdge(1, prerequisites[i][1], prerequisites[i][0]);
        }
        for (Node node : graph.nodes.values()) {
            if (!dfs(node)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Node node) {
        if (node.visited) {
            return true;
        }
        if (node.inPath) {
            return false;
        }
        node.inPath = true;
        for (Edge edge : node.edges) {
            if (!dfs(edge.destination)) {
                return false;
            }
        }
        node.inPath = false;
        node.visited = true;
        return true;
    }

    public static class Graph {
        HashMap<Integer, Node> nodes;

        Graph() {
            nodes = new HashMap<>();
        }

        private void addNode(int val) {
            nodes.put(val, new Node(val));
        }

        private void addEdge(int weight, int source, int dest) {
            nodes.get(source).edges.add(new Edge(weight, nodes.get(source), nodes.get(dest)));
        }
    }

    public static class Node {
        int val;
        boolean inPath;
        boolean visited;
        List<Edge> edges;

        Node() {
            edges = new LinkedList<>();
            this.visited = false;
        }

        Node(int val) {
            this.val = val;
            this.edges = new LinkedList<>();
            this.visited = false;
        }
    }

    public static class Edge {
        int weight;
        Node source;
        Node destination;

        Edge(int weight, Node source, Node destination) {
            this.weight = weight;
            this.source = source;
            this.destination = destination;
        }
    }
}
