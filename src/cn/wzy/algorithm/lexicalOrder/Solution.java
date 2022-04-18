package cn.wzy.algorithm.lexicalOrder;

import java.util.*;

class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> rst = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            rst.add(i);
        }
        rst.sort(Comparator.comparing(String::valueOf));
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(13));
    }
}