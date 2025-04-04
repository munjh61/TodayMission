package d0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA벽돌깨기 {
	static int N, W, H; // 구슬 회수 , 너비 W, 높이 H

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[H][W];
			for (int row = 0; row < H; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < W; col++) {
					matrix[row][col] = Integer.parseInt(st.nextToken());
				}
			} // 입력 종료
			minCnt = Integer.MAX_VALUE;
			game(matrix, 0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			if (minCnt == Integer.MAX_VALUE) {
				sb.append(0);
			} else
				sb.append(minCnt);
			System.out.println(sb);
		}
	}

	static int[][] instance;
	static boolean[][] visited;
	static int minCnt;

	private static void game(int[][] matrix, int gamecnt) {
		// 종료 부분
		if (gamecnt == N) {
			int cnt = 0;
			for (int row = 0; row < H; row++) {
				for (int col = 0; col < W; col++) {
					if (matrix[row][col] != 0)
						cnt++;
				}
			}
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		// 재귀 부분
		for (int col = 0; col < W; col++) {
			makeInstance(matrix);
			int row = 0;
			for (; row < H; row++) {
				if (matrix[row][col] != 0)
					break;
			}
			if (row == H) { // 이미 바닥까지 다 깬 열이다
				continue;
			}
			visited = new boolean[H][W];
			boom(row, col);
			// 합치기
			putTogether();
			game(instance, gamecnt + 1);
		}

	}

	static void makeInstance(int[][] matrix) {
		instance = new int[H][W];
		for (int row = 0; row < H; row++) {
			for (int col = 0; col < W; col++) {
				instance[row][col] = matrix[row][col];
			}
		}
	}

	static void boom(int row, int col) {
		visited[row][col] = true;
		int d = instance[row][col] - 1;

		int cmin = col - d;
		int cmax = col + d;
		int rmin = row - d;
		int rmax = row + d;

		for (int nc = cmin; nc <= cmax; nc++) {
			if (nc < 0)
				continue;
			if (nc >= W)
				break;
			if (visited[row][nc])
				continue;
			boom(row, nc);
		}
		for (int nr = rmin; nr <= rmax; nr++) {
			if (nr < 0)
				continue;
			if (nr >= H)
				break;
			if (visited[nr][col])
				continue;
			boom(nr, col);
		}
	}

	static void putTogether() {
		for (int col = 0; col < W; col++) {
			int[] tmp = new int[H];
			for (int row = H - 1, idx = H - 1; row >= 0; row--) {
				if (!visited[row][col])
					tmp[idx--] = instance[row][col];
			}
			for (int row = 0; row < H; row++) {
				instance[row][col] = tmp[row];
			}
		}
	}

}
