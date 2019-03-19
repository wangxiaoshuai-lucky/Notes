package cn.wzy.baicizhan;

import java.util.*;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] str1 = scan.next().toCharArray();
		char[] str2 = scan.next().toCharArray();
		for (int i = 0, j = str1.length - 1; i < j; i++, j--){
			char tmp = str1[i];
			str1[i] = str1[j];
			str1[j] = tmp;
		}
		for (int i = 0, j = str2.length - 1; i < j; i++, j--){
			char tmp = str2[i];
			str2[i] = str2[j];
			str2[j] = tmp;
		}
		List<Character> ans = new ArrayList<>();
		int len = str1.length > str2.length?str1.length : str2.length;
		int up = 0;
		for (int i = 0; i < len; i++) {
			int now;
			if (i < str1.length && i < str2.length) {
				now = (str1[i] - 'a') + (str2[i] - 'a') + up;
			} else if (i < str1.length) {
				now = (str1[i] - 'a') + up;
			} else {
				now = (str2[i] - 'a') + up;
			}
			up = now / 26;
			now %= 26;
			ans.add((char) ('a' + now));
		}
		if (up != 0) {
			ans.add((char) ('a' + up));
		}
		Collections.reverse(ans);
		System.out.println(ans);
	}
}
