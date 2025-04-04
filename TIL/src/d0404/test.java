package d0404;

public class test {
	public static void main(String[] args) {
		int[][] map = new int[10][10];
		System.out.println();
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if(row <= col)
					System.out.print(0 + " ");
				else
					System.out.print(1 + " ");
			}
			System.out.println();
		}
	}
}
