package cn.wzy.algorithm.dijkstra;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] graph = initGraph();
        for (int i =0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        dijkstra(graph);
    }

    private static int[][] initGraph() {
        final int N = 6, INF = 10;

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = INF;
            }
            graph[i][i] = 0;
        }

        graph[0][1] = graph[1][0] = 1;
        graph[0][2] = graph[2][0] = 2;
        graph[0][3] = graph[3][0] = 4;
        graph[1][4] = graph[4][1] = 2;
        graph[2][4] = graph[4][2] = 3;
        graph[3][5] = graph[5][3] = 1;
        graph[2][5] = graph[5][2] = 1;

        return graph;
    }

    private static void dijkstra(int[][] graph) {
        final int n = graph.length;

        boolean[] found = new boolean[n];
        int[] rst = new int[n];
        for (int i = 0; i < n; i++) {
            rst[i] = graph[i][0];
        }
        found[0] = true;
        for (int count = 1; count < n; count++) {

            int curMin = 1 << 31 - 1, minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (!found[i] && rst[i] < curMin) {
                    curMin = rst[i];
                    minIndex = i;
                }
            }
            found[minIndex] = true;
            for (int i = 0; i < n; i++) {
                rst[i] = Math.min(rst[i], rst[minIndex] + graph[minIndex][i]);
            }
        }

        System.out.println(Arrays.toString(rst));
    }
}
