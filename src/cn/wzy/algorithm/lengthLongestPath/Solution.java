package cn.wzy.algorithm.lengthLongestPath;

import sun.misc.Regexp;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int lengthLongestPath(String input) {
        int maxLength = 0;
        Map<Integer, String> levelDir = new HashMap<>();
        String[] inputs = input.split("\n");
        for (String cur : inputs) {
            int idx = cur.lastIndexOf("\t");
            int level = idx + 1;
            String prePath = levelDir.get(level - 1);
            if (prePath == null) {
                prePath = "";
            }
            String name = cur.substring(idx + 1);
            if (name.contains(".")) {// file
                String filename = prePath + name;
                System.out.println(filename);
                maxLength = Math.max(maxLength, filename.length());
            } else {
                String curPath = prePath + name + "/";
                levelDir.put(level, curPath);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPath("1"));
    }
}