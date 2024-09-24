package io.dataStructures;

import java.util.*;

class Q9 {
    private Map<Integer, List<Integer>> adjList;

    public Q9() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {//adds adjacent nodes to a particular node.
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(int node, Set<Integer> visited) {
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void dfsIterative(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                System.out.print(node + " ");
                visited.add(node);
                List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
                Collections.reverse(neighbors);
                for (int neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Q9 g = new Q9();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS Recursive starting from vertex 2:");
        g.dfs(2);

        System.out.println("\nDFS Iterative starting from vertex 2:");
        g.dfsIterative(2);

        System.out.println("\nBFS starting from vertex 2:");
        g.bfs(2);
    }
}

