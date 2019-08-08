package cn.wzy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * IpCounter
 * @author  WangZY
 * @since  2019/7/23 14:44
 * @version  1.0
 **/
public class IpCounter {

    public static void main(String[] args) {
        String ip = "25525511135";
        List<String> result = new ArrayList<>();
        dfs(new ArrayList<>(), 1, ip, result);
        System.out.println(result);
    }

    private static boolean check(String str) {
        if (str.startsWith("0") && str.length() > 1 || str.equals("")) {
            return false;
        }
        return str.length() <= 3 && Integer.valueOf(str) <= 255;
    }

    private static String printf(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(list.get(i));
            if (i != 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static void dfs(List<String> list, int step, String last, List<String> result) {
        // 最后一步，检测是否合适
        if (step == 4) {
            list.add(last);
            if (check(last)) {
                result.add(printf(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        for (int i = 1; i <= 3 && i <= last.length(); i++) {
            String now = last.substring(0, i);
            if (!check(now)) {
                return;
            }
            String newLast = "";
            if (i != last.length()) {
                newLast = last.substring(i);
            }
            list.add(now);
            dfs(list, step + 1, newLast, result);
            list.remove(list.size() - 1);
        }
    }
}
