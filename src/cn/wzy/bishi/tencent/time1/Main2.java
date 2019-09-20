package cn.wzy.bishi.tencent.time1;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = 100000;
		}
		BigDecimal[][] totalScore = new BigDecimal[n][n];
		int[][] minScore = new int[n][n];
		BigDecimal max = new BigDecimal(-1);
		for (int i = 0; i < n; i++) {
			totalScore[i][i] = new BigDecimal(scores[i]);
			minScore[i][i] = scores[i];
			for (int j = i + 1; j < n; j++) {
				totalScore[i][j] = totalScore[i][j - 1].add(new BigDecimal(scores[j]));
				minScore[i][j] = min(minScore[i][j - 1], scores[j]);
				BigDecimal now = totalScore[i][j].multiply(new BigDecimal(minScore[i][j]));
				if (now.compareTo(max) > 0) {
					max = now;
				}
			}
		}
		System.out.println(max);
	}
}
