package d0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3289 {
	static int[] p;
	static int[] rank;
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			if (sb.length() != 0)
				sb.append("\n");
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			p = new int[n + 1];
			rank = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				switch (op) {
				case "0":
					union(x, y);
					break;
				case "1":
					sb.append(find(x) == find(y) ? 1 : 0);
				}
			}
		}
		System.out.println(sb);

	}

	static int find(int x) {
		if (x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return;
		if (rank[px] > rank[py]) {
			p[py] = px;
		} else if (rank[px] == rank[py]) {
			p[px] = py;
			rank[py]++;
		} else {
			p[px] = py;
		}

	}

}
