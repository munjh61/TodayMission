package d0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1248 {
	static int[][] tree;
	static int treesize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= testcase; tc++) {

			// input1, tree 선언
			String[] strArr = br.readLine().split(" ");
			int V = Integer.parseInt(strArr[0]);
			tree = new int[V + 1][4]; // [왼쪽자식][오른쪽자식][부모][레벨]
			int E = Integer.parseInt(strArr[1]);
			int c1 = Integer.parseInt(strArr[2]);
			int c2 = Integer.parseInt(strArr[3]);

			// input2, tree 저장
			strArr = br.readLine().split(" ");
			for (int v = 0, idx = 0; v < E; v++) {
				int p = Integer.parseInt(strArr[idx++]);
				int c = Integer.parseInt(strArr[idx++]);
				if (tree[p][0] == 0) {
					tree[p][0] = c;
				} else {
					tree[p][1] = c;
				}
				tree[c][2] = p;
			}
			
			// 조건 : 루트의 정점은 항상 1번이다
			levelup(1,0);
			
			// treesize 초기화
			treesize = 0;

			while (c1 != c2) { // 부모가 같아질 때까지
				// 레벨이 같아지겠금하자
				if (tree[c1][3] > tree[c2][3]) {
					c1 = getParent(c1);
				} else if (tree[c1][3] < tree[c2][3]) {
					c2 = getParent(c2);
				} else {
					c1 = getParent(c1);
					c2 = getParent(c2);
				}
			}
			;

			// 트리 사이즈 구하기
			getTreeSize(c1);

			if (sb.length() != 0) {
				sb.append("\n");
			}
			sb.append("#" + tc + " " + c1 + " " + treesize);

		} // tc }
		System.out.println(sb.toString());

		br.close();
	}

	static int getParent(int idx) {
		return tree[idx][2];
	}

	static void getTreeSize(int idx) {
		treesize++;
		if (tree[idx][0] != 0) {
			getTreeSize(tree[idx][0]);
		}
		if (tree[idx][1] != 0) {
			getTreeSize(tree[idx][1]);
		}
	}

	static void levelup(int idx, int level) {
		level++;
		tree[idx][3] = level;
		//----왼쪽----
		int left = tree[idx][0];
		if (left != 0) {
			levelup(left, level);
		}
		//----오른쪽----		
		int right = tree[idx][1];
		if (right != 0) {
			levelup(right, level);
		}
	}
}
