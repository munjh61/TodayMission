package d0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_1249_보급로pq {
	
	static class Edge implements Comparable<Edge>{
		int x, y, time;

		@Override
		public int compareTo(Edge o) {
			return this.time - o.time;
		}
		
	}
	
	static int[][] map;
	static int N;
	static int[][] time;
	static boolean[][] visited;
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
			visited = new boolean[N][N];
			String str;
			for (int row = 0; row < N; row++) {
				str = br.readLine();
				for (int col = 0; col < N; col++) {
					map[row][col] = str.charAt(col) - '0';
					time[row][col] = INF;
				}
			} // 입력 }
			time[0][0] = 0;
			visited[0][0] = true;
			
			move();

			if (sb.length() != 0)
				sb.append("\n");
			sb.append("#").append(tc).append(" ").append(time[N - 1][N - 1]);

		} // tc
		System.out.println(sb);
	}

	static void move() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
	}
}
