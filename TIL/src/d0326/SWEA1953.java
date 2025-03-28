package d0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {
	static int N; // row
	static int M; // col
	static int startR;
	static int startC;
	static int L; // 시간

	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < M; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(startR, startC);

			int cnt = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					if (visited[row][col])
						cnt++;
				}
			}

			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb);
		}

	}

	/*
	 * + │ ─ └ ┌ ┐ ┘
	 */
	static int[][] drow = { {}, { -1, 1, 0, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
	static int[][] dcol = { {}, { 0, 0, -1, 1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

	static void dfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, 1 });
		visited[r][c] = true;

		while (!q.isEmpty()) {

			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int ct = curr[2];

			if (ct >= L)
				return;

			int type = map[cr][cc];
			int[] ndrow = drow[type];
			int[] ndcol = dcol[type];

			for (int d = 0; d < ndrow.length; d++) {
				int nr = cr + ndrow[d];
				int nc = cc + ndcol[d];
				int ntime = ct + 1;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (visited[nr][nc])
					continue;
				int type2 = map[nr][nc];

				int[] ndrow2 = drow[type2];
				int[] ndcol2 = dcol[type2];

				boolean able = false;
				for (int d2 = 0; d2 < ndrow2.length; d2++) {
					if (ndrow[d] + ndrow2[d2] == 0 && ndcol[d] + ndcol2[d2] == 0)
						able = true;
				}
				if (able) {
					q.add(new int[] { nr, nc, ntime });
					visited[nr][nc] = true;
				}
			}
		}

	}
}
