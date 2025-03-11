package d0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7733 {
	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dRow = { 1, -1, 0, 0 };
	static int[] dCol = { 0, 0, 1, -1 };
	static int chunk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			// 초기화 ---------------------
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			chunk = 0;
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < N; col++) {
					cheese[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			// 계산 ---------------------
			for (int day = 0; day <= 100; day++) {
				visited = new boolean[N][N];
				for (int row = 0; row < N; row++) {
					for (int col = 0; col < N; col++) {
						if (cheese[row][col] <= day)
							visited[row][col] = true;
					}
				}
				int cnt = 0;
				for (int row = 0; row < N; row++) {
					for (int col = 0; col < N; col++) {
						if(!visited[row][col]) {
							calc(row, col);
							cnt++;
						}
					}
				}
				chunk = Math.max(chunk, cnt);
			}
			if(sb.length() !=0 )
				sb.append("\n");
			sb.append("#").append(tc).append(" ").append(chunk);
		} // tc
		System.out.println(sb);
		
		br.close();
	}

	static void calc(int row, int col) {
		visited[row][col] = true;
		for (int d = 0; d < 4; d++) {
			int nextRow = row + dRow[d];
			int nextCol = col + dCol[d];

			if (nextRow < N && nextRow >= 0 && nextCol < N && nextCol >= 0) {
				if (!visited[nextRow][nextCol]) {
					calc(nextRow, nextCol);
				}
			}
		}
	}

}
