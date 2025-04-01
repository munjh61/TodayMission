package d0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1267_작업순서 {

	static int V; // 정점
	static int E; // 간선
	static int[]degree;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			degree = new int[V+1];
			list = new ArrayList[V+1];
			for(int i = 1 ; i <= V ; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int before = Integer.parseInt(st.nextToken());
				int after = Integer.parseInt(st.nextToken());
				list[before].add(after);
				degree[after]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1 ; i <= V ; i++) {
				if(degree[i]==0)
					q.add(i);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			while(!q.isEmpty()) {
				int curr = q.poll();
				sb.append(curr).append(" ");
				for(int after : list[curr]) {
					degree[after]--;
					if(degree[after]==0)
						q.add(after);
				}
			}
			System.out.println(sb.toString().trim());
		}
	}
	
}
