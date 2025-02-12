package d0212_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q재밌는_오셀로_게임 {
	static int[][] table;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) {
				String[] str = br.readLine().split(" ");
				int N = Integer.parseInt(str[0]);
				int M = Integer.parseInt(str[1]);
				table = new int[N][N];
				int c = N / 2;
				table[c - 1][c - 1] = 2;
				table[c][c] = 2;
				table[c - 1][c] = 1;
				table[c][c - 1] = 1;
				for (int play = 0; play < M; play++) {
					str = br.readLine().split(" ");
					int row = Integer.parseInt(str[0]) - 1;
					int col = Integer.parseInt(str[1]) - 1;
					int type = Integer.parseInt(str[2]);
					int oppositeType = type == 1 ? 2 : 1;
					table[row][col] = type;
					// 상
					int d = 1;
					boolean othersideSameType = false;
					while (row - d >= 0) { // 건너편 가장 가까운 같은 색깔 찾기
						if (table[row - d][col] == oppositeType) { // 다른 색이면 더 탐색
							d++;
						} else if (table[row - d][col] == type) { // 같은 색이면 종료
							othersideSameType = true; // 색 변경 가능
							break;
						} else { // 비어진 자리면 종료
							break;
						}
					}

					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row - change][col] = type;
							change++;
						}
					}
					// 하
					d = 1;
					othersideSameType = false;
					while (row + d < N) { // 건너편 가장 가까운 같은 색깔 찾기
						if (table[row + d][col] == oppositeType) {
							d++;
						} else if (table[row + d][col] == type) {
							othersideSameType = true;
							break;
						} else {
							break;
						}
					}
					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row + change][col] = type;
							change++;
						}
					}
					// 좌
					d = 1;
					othersideSameType = false;
					while (col - d >= 0) { // 건너편 가장 가까운 같은 색깔 찾기
						if (table[row][col - d] == oppositeType) {
							d++;
						} else if (table[row][col - d] == type) {
							othersideSameType = true;
							break;
						} else {
							break;
						}
					}
					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row][col - change] = type;
							change++;
						}
					}
					// 우
					d = 1;
					othersideSameType = false;
					while (col + d < N) { // 건너편 가장 가까운 같은 색깔 찾기
						if (table[row][col + d] == oppositeType) {
							d++;
						} else if (table[row][col + d] == type) {
							othersideSameType = true;
							break;
						} else {
							break;
						}
					}
					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row][col + change] = type;
							change++;
						}
					}
					// 대각선 ↖ row-- col--
					d = 1;
					othersideSameType = false;
					while (row - d >= 0 && col - d >= 0) {
						if (table[row - d][col - d] == oppositeType) {
							d++;
						} else if (table[row - d][col - d] == type) {
							othersideSameType = true;
							break;
						} else {
							break;
						}
					}
					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row - change][col - change] = type;
							change++;
						}
					}
					// 대각선 ↘ row++ col++
					d = 1;
					othersideSameType = false;
					while (row + d < N && col + d < N) {
						if (table[row + d][col + d] == oppositeType) {
							d++;
						} else if (table[row + d][col + d] == type) {
							othersideSameType = true;
							break;
						} else {
							break;
						}
					}
					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row + change][col + change] = type;
							change++;
						}
					}
					// 대각선 ↗ row-- col++
					d = 1;
					othersideSameType = false;
					while (row - d >= 0 && col + d < N) {
						if (table[row - d][col + d] == oppositeType) {
							d++;
						} else if (table[row - d][col + d] == type) {
							othersideSameType = true;
							break;
						} else {
							break;
						}
					}
					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row - change][col + change] = type;
							change++;
						}
					}
					// 대각선 ↙ row++ col--
					d = 1;
					othersideSameType = false;
					while (row + d < N && col - d >= 0) {
						if (table[row + d][col - d] == oppositeType) {
							d++;
						} else if (table[row + d][col - d] == type) {
							othersideSameType = true;
							break;
						} else {
							break;
						}
					}
					if (othersideSameType) { // 색 변경
						int change = 1;
						while (change <= d) {
							table[row + change][col - change] = type;
							change++;
						}
					}
				}
				// 갯수 세기
				int black = 0;
				int white = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (table[i][j] == 1) {
							black++;
						} else if (table[i][j] == 2) {
							white++;
						}
					}
				}
				System.out.println("#" + tc + " " + black + " " + white);
			} // testcase }
		} catch (IOException e) {

		}
	} // main }
	/*
	public static void showtable(int[][] arr) {
		for (int[] row : arr) {
			for (int elem : row) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
		System.out.println("-".repeat(40));
	}
	*/
}
