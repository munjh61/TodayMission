package d0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {

	static List<Integer>[] edges;
	static int[] order;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			edges = new ArrayList[101];
			visited = new boolean[101];
			order = new int[101];
			Arrays.fill(order, Integer.MAX_VALUE);
			for (int i = 0; i < 101; i++) {
				edges[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			order[start] = 1;

			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				edges[from].add(to);
			}

			
			dijkstra(start, 1);

			int max = 0;
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < 101; i++) {
				if (visited[i]) {
					if (max < order[i]) {
						list.clear();
						max = order[i];
						list.add(i);
					} else if (max == order[i])
						list.add(i);
				}
			}

			int result = Collections.max(list);

			if (sb.length() != 0)
				sb.append("\n");
			sb.append("#").append(tc).append(" ").append(result);
		}
		System.out.println(sb);
	} // main

	static void dijkstra(int start, int num) {
		visited[start] = true;
		for (int i : edges[start]) {
			if (num < order[i]) {
				order[i] = num + 1;
				dijkstra(i, num + 1);
			}

		}
	}

}
