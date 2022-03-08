package cn.wzy.algorithm;

import java.util.Arrays;

public class UnionFind {
    private static final int[] fa = new int[10];

    private static void union(int i, int j) {
        fa[find(i)] = fa[find(j)];
    }

    private static int find(int i) {
        if (fa[i] != i) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    private static boolean isSame(int i, int j) {
        return find(i) == find(j);
    }

    public static void main(String[] args) {
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        System.out.println(Arrays.toString(fa));

        System.out.println(isSame(1, 2));
        union(1, 2);
        System.out.println(Arrays.toString(fa));
        System.out.println(isSame(1, 2));

        System.out.println(isSame(4, 2));
        union(4, 2);
        System.out.println(Arrays.toString(fa));
        System.out.println(isSame(4, 2));
    }
}
