package cn.wzy.algorithm;

/**
 * @ClassName IpCounter
 * @Author WangZY
 * @Date 2019/7/23 14:44
 * @Version 1.0
 **/
public class IpCounter {

    static void dfs(String str, int[] index, int time) {
        if (time == 4) {
            if (check(str, index)) {
                int k = 1;
                for (int i = 0; i < str.length(); i++) {
                    System.out.print(str.charAt(i));
                    if (k <= 3 && index[k] == i) {
                        System.out.print(".");
                        k++;
                    }
                }
                System.out.println();
            }
            return;
        }
        for (int i = index[time - 1] + 1, t = 0; t < 3;t++, i++) {
            index[time] = i;
            dfs(str, index, time + 1);
        }
    }

    static boolean check(String str, int[] index) {
        for (int i = 1; i <= 4; i++) {
            String now;
            if (i != 4) {
                now = str.substring(index[i - 1] + 1, index[i] + 1);
            } else {
                now = str.substring(index[i  -1] + 1);
            }
            if (now.startsWith("0") && now.length() != 1) {
                return false;
            }
            if (Integer.valueOf(now) > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ip = "25525511323";
        dfs(ip, new int[]{-1, 0, 0, 0}, 1);
    }
}
