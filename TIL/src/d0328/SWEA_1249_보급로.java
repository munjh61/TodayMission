package d0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1249_보급로 {
	static int[][] map;
	static int N;
	static int[][] time;
	static final int INF = Integer.MAX_VALUE;

	// 하 우 상 좌
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			time = new int[N][N];
			String str;
			for (int row = 0; row < N; row++) {
				str = br.readLine();
				for (int col = 0; col < N; col++) {
					map[row][col] = str.charAt(col) - '0';
					time[row][col] = INF;
				}
			} // 입력 }
			time[0][0] = 0;

			move(0, 0);

			if (sb.length() != 0)
				sb.append("\n");
			sb.append("#").append(tc).append(" ").append(time[N - 1][N - 1]);

		} // tc
		System.out.println(sb);
	}

	static void move(int row, int col) {

		if (row == N && col == N)
			return;

		for (int d = 0; d < 4; d++) {
			int nrow = row + dx[d];
			int ncol = col + dy[d];

			if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= N)
				continue;
			if (time[nrow][ncol] > time[row][col] + map[nrow][ncol]) {
				time[nrow][ncol] = time[row][col] + map[nrow][ncol];
				move(nrow, ncol);
			}
		}
	}
}
