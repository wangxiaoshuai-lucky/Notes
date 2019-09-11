package cn.wzy.bishi.meituan.time2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static String[] single = new String[]{
		"零", "壹", "贰","叁","肆","伍","陆","柒","捌","玖"
	};

	static String[] bind = new String[] {
		"仟","佰","拾","","万","亿","角","分","零"
	};

	static String[] levelName = new String[]{
		"", "万", "亿"
	};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String param = scanner.next();
		param = param.substring(1, param.length() - 1).replace("\"", "");
		String[] strs = param.split(",");
		List<String> ans = new ArrayList<>();
		for (String s: strs) {
			ans.add(convert(s, 0) + "元整");
		}
		System.out.println(ans);
	}

	// 只处理最后四位
	public static String convert(String number, int level) {
		String now = null;
		if (number.length() > 4) {
			String ans = "";
			now = number.substring(number.length() - 4);
			ans += single[now.charAt(0) - '0'];
			if (!ans.contains("零")) {
				ans += "仟";
			}
			if (!ans.contains("零") || now.charAt(1) != '0') {
				ans += single[now.charAt(1) - '0'] + "佰";
			}
			if (!ans.contains("零") || now.charAt(2) != '0') {
				ans += single[now.charAt(2) - '0'] + "拾";
			}
			if (!ans.contains("零") || now.charAt(3) != '0') {
				ans += single[now.charAt(3) - '0'];
			}
			ans += levelName[level];
			return convert(number.substring(0, number.length() - 4), level + 1) + ans;
		} else {
			now = number;
			int len = 4 - now.length();
			for (int i = 0; i < len; i++) {
				now = "0" + now;
			}
			String ans = "";
			for (int i = len; i < 4; i++) {
				ans += single[now.charAt(i) - '0'] + bind[i];
			}
			return ans + levelName[level];
		}
	}

	// 4位转文字
	static String print1(String str) {
		if (str.contains("000")) {
			return single[str.charAt(0) - '0'] + bind[0];
		} else if (str.contains("0")) {
			String ans = "";

			if (str.contains("00")) {

			}
			return "0";
		} else {
			String ans = "";
			for (int i = 0; i < 4; i++) {
				ans += single[str.charAt(i) - '0'] + bind[i];
			}
			return "ans";
		}
	}
}
