package d0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA7733_BFS {
	static int N;
	static int[][] cheese;
	static boolean visited[][];

	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());

			cheese = new int[N][N];

			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < N; col++) {
					cheese[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for (int day = 0; day <= 100; day++) {
				visited = new boolean[N][N];
				int cnt = 0;
				for (int row = 0; row < N; row++) {
					for (int col = 0; col < N; col++) {
						if (!visited[row][col] && cheese[row][col] > day) {
							bfs(new Pos(row, col), day);
							cnt++;
						}
					}
				}
				max = cnt > max ? cnt : max;
			}
			sb.append(max);
			System.out.println(sb);
		}
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void bfs(Pos p, int day) {
		Queue<Pos> q = new LinkedList<>();

		q.add(p);
		visited[p.r][p.c] = true;

		while (!q.isEmpty()) {
			Pos curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nrow = curr.r + drow[d];
				int ncol = curr.c + dcol[d];

				if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= N)
					continue;
				if (visited[nrow][ncol])
					continue;
				if (cheese[nrow][ncol] <= day)
					continue;
				q.add(new Pos(nrow, ncol));
				visited[nrow][ncol] = true;
			}
		} // while
	} // bfs

}
