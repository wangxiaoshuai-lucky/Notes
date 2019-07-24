package cn.wzy.bishi.bytedance.time2;

import java.util.Scanner;

/**
 * @ClassName Dijkstra
 * @Author WangZY
 * @Date 2019/7/19 17:32
 * @Version 1.0
 **/
public class Dijkstra {

    static int[][] map;

    static int[] dis;

    static boolean[] confirm;

    static void dijkstra() {
        for (int i = 0; i < confirm.length; i++) {
            int min = getMin();
            changeDis(min);
        }
    }

    static void changeDis(int index) {
        for (int i = 0; i < dis.length; i++) {
            if (index != i && map[index][i] != -1 && dis[i] > dis[index] + map[index][i]) {
                dis[i] = dis[index] + map[index][i];
            }
        }
    }

    static int getMin() {
        int min = -1;
        for (int i = 0; i < dis.length; i++) {
            if (!confirm[i]) {
                if (min == -1 || dis[min] > dis[i]) {
                    min = i;
                }
            }
        }
        confirm[min] = true;
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dis = new int[n];
        for (int i = 1; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        confirm = new boolean[n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    map[i][j] = -1;
                }
            }
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            map[a][b] = map[b][a] = c;
        }
        dijkstra();
        for (Integer i: dis) {
            System.out.print(i + ",");
        }
    }
}
