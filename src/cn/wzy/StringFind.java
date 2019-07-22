package cn.wzy;

/**
 * @ClassName StringFind
 * @Author WangZY
 * @Date 2019/7/22 14:53
 * @Version 1.0
 **/
public class StringFind {

    static int[] initNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    static int index(String a, String pattern, int[] next) {
        int i = 0, j = 0;
        while (i < a.length() && j < pattern.length()) {
            if (j == -1) {
                j++;
                i++;
            } else if (a.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return i - j;
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcdaadadeaadfsw";
        String b = "adeadad";
        System.out.println(index(a, b, initNext(b)));
    }
}
