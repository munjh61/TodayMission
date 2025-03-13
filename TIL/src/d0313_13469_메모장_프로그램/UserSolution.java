package d0313_13469_메모장_프로그램;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UserSolution {
	static List<Queue<Character>> list = new ArrayList<>();
	static int cursorRow = 0;
	static int cursorCol = 0;

	void init(int H, int W, char mStr[]) {
		int idx = 0;
		for (int row = 0; row < H; row++) {
			list.add(new LinkedList<>());
			for (int col = 0; col < W; col++) {
				list.get(row).add(mStr[idx++]);
			}
		}
	}

	void insert(char mChar) {

	}

	char moveCursor(int mRow, int mCol) {
		return '$';
	}

	int countCharacter(char mChar) {
		return -1;
	}
}