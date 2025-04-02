package d0331;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA5643_키순서_failed {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] depthSF = new int[N + 1]; // smaller pick first
			int[] depthTF = new int[N + 1]; // taller pick first
			List<Integer>[] listSF = new ArrayList[N + 1];
			List<Integer>[] listTF = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				listSF[i] = new ArrayList<>();
				listTF[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				int small = sc.nextInt();
				int tall = sc.nextInt();
				depthSF[tall]++;
				listSF[small].add(tall);
				depthTF[small]++;
				listTF[tall].add(small);
			}
			int unable = 0;
			Queue<Integer> queueSF = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (depthSF[i] == 0) {
					queueSF.add(i);
				}
			}
			while (!queueSF.isEmpty()) {
				int curr = queueSF.poll();
				if(queueSF.isEmpty())
					break;
				int next = queueSF.peek();
				depthSF[next]--;
				if (depthSF[next] != 0)
					break;
				else {
					for(int i : listSF[curr]) {
						depthSF[i]--;
						if(depthSF[i] == 0) {
							queueSF.add(i);
						}
					}
					unable++;
				}
			}
			Queue<Integer> queueTF = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (depthTF[i] == 0) {
					queueTF.add(i);
				}
			}
			while (!queueTF.isEmpty()) {
				int curr = queueTF.poll();
				if(queueTF.isEmpty())
					break;
				int next = queueTF.peek();
				depthTF[next]--;
				if (depthTF[next] != 0)
					break;
				else {
					for(int i : listTF[curr]) {
						depthTF[i]--;
						if(depthTF[i] == 0) {
							queueTF.add(i);
						}
					}
					unable++;
				}
			}
			System.out.println(N - unable);
		}
	}
}
