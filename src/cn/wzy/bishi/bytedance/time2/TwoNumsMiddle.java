package cn.wzy.bishi.bytedance.time2;

/**
 * @ClassName TwoNumsMiddle 两个数组的中位数
 * @Author WangZY
 * @Date 2019/7/22 11:24
 * @Version 1.0
 **/
public class TwoNumsMiddle {

    static double getMiddle(double[] num1, double[] num2, int k) {
        int i = 0, j = 0;
        int nowTop = 0;
        double pre = -1;
        double now = -1;
        while (nowTop < k + 1) {
            pre = now;
            if (i == num1.length) {
                now = num2[j++];
            } else if (j == num2.length) {
                now = num1[i++];
            } else if (num1[i] < num2[j]) {
                now = num1[i++];
            } else {
                now = num2[j++];
            }
            nowTop++;
        }
        System.out.println(pre + ", " + now);
        return now;
    }

    public static void main(String[] args) {
        double[] num1 = new double[]{1, 3, 5, 7, 9};
        double[] num2 = new double[]{2, 4, 6, 8, 10};
        int len = num1.length + num2.length;
        int k = len / 2;
        getMiddle(num1, num2, k);
    }
}
