package d0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1247_최적_경로 {

	static int N;
	static int[][] loc;
	static int[][] dist;
	static boolean[] visited;
	static int result;
	static int[] path;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 고객의 수
			loc = new int[N + 2][2]; // 0 : 회사, 1 : 집, 2 ~ N+1 : 고객 집
			dist = new int[N + 2][N + 2];
			visited = new boolean[N + 2];
			result = Integer.MAX_VALUE;
			path = new int[N + 2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			calcdist();
			visited[0] = true;
			move(0, 1, 0, 0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(result);
			System.out.println(sb);
		}
	}

	static void calcdist() {
		for (int from = 0; from < N + 2; from++) {
			for (int to = from + 1; to < N + 2; to++) {
				dist[from][to] = Math.abs(loc[from][0] - loc[to][0]) + Math.abs(loc[from][1] - loc[to][1]);
				dist[to][from] = dist[from][to];
			}
		}
	}

	static void move(int from, int next, int sum, int size) {
		if (size == N + 1) {
			result = Math.min(sum, result);
			return;
		}
		if (size < N + 1 && visited[1]) {
			return;
		}

		for (int nidx = 0; nidx < N + 2; nidx++) {
			if (visited[nidx])
				continue;
			visited[nidx] = true;
			path[next] = nidx;
			move(nidx, next + 1, sum + dist[from][nidx], size + 1);
			visited[nidx] = false;
		}

	}
}
