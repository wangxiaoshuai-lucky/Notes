package cn.wzy.bishi.bytedance.time2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName FirstChar
 * @Author WangZY
 * @Date 2019/7/22 9:35
 * @Version 1.0
 **/
public class FirstChar {
    public static void main(String[] args) {
        String str = "google";
        int[] count = new int[26];
        Queue<Character> queue = new LinkedList<>();
        for (Character ch: str.toCharArray()) {
            queue.add(ch);
            count[ch - 'a']++;
            while (!queue.isEmpty() && count[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
        }
        System.out.println(queue.isEmpty()?0:queue.peek());
    }
}
