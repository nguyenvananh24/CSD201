package com.mycompany.dijkstra;

import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Node> adjList[];

    class Node {
        int vertex, weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }
    }

    Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest, int weight) {
        adjList[src].add(new Node(dest, weight));
        adjList[dest].add(new Node(src, weight)); // Nếu đồ thị vô hướng
    }

    void dijkstra(int startVertex) {
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            int vertex = pq.poll().vertex;
            visited[vertex] = true;

            for (Node node : adjList[vertex]) {
                if (!visited[node.vertex]) {
                    int newDist = distances[vertex] + node.weight;
                    if (newDist < distances[node.vertex]) {
                        distances[node.vertex] = newDist;
                        pq.add(new Node(node.vertex, newDist));
                    }
                }
            }
        }

        System.out.println("Khoảng cách từ đỉnh " + startVertex + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Đến " + i + " : " + distances[i]);
        }
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);

        graph.dijkstra(0);
    }
}

