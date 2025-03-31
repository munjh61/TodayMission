package d0331;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo2_서울_09_문준호 {

	static int N; // 사람의 수
	static int M; // 관계의 수
	static ArrayList<Integer>[] ilchon; // 일촌 관계 저장
	static boolean visited[];
	static int[] dist;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 사람의 수
			M = sc.nextInt(); // 관계의 수

			ilchon = new ArrayList[N + 1];
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				ilchon[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				int p = sc.nextInt(); // 부모
				int c = sc.nextInt(); // 자식

				ilchon[p].add(c);
				ilchon[c].add(p);
			}
			for (int i = 1; i <= N; i++) { // 나 기준에서 새로 해야하므로 전부 초기화
				dist = new int[N + 1];
				visited = new boolean[N + 1];
				bfs(i);
			}
			
			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(cnt/2);
			System.out.println(sb);
		}

		sc.close();
	}

	static void bfs(int num) {
		Queue<Integer> q = new LinkedList();
		q.add(num);
		visited[num] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (dist[curr] == 3) { // 사촌 이상 필요 없음
				break;
			}
			for (int next : ilchon[curr]) { //연결된 것 중에서
				if (!visited[next]) { // 방문하지 않았다면
					q.add(next);
					visited[next] = true; // 바로 방문처리
					dist[next] = dist[curr] + 1; // 촌수 거리 +1
					if (dist[next] == 3) { // 삼촌이면 +1
						cnt++;
					}
				}
			}
		}
	}
}
