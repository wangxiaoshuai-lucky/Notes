package cn.wzy.algorithm.floyd;

import java.util.Arrays;

public class Floyd {

    public static void main(String[] args) {
        int[][] dist = initGraph();
        for (int[] value : dist) {
            System.out.println(Arrays.toString(value));
        }

        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    dist[i][j] = dist[j][i] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int[] ints : dist) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] initGraph() {
        final int N = 6, INF = 999999;

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
}
