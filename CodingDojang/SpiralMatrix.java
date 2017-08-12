import java.util.Scanner;

public class SpiralMatrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//row행 col열
		int row = scan.nextInt();
		int col = scan.nextInt();
		
		int[][] numArr = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				numArr[i][j] = -1;
			}
		}

		int num;
		int pivot = 0;
		int turn_num = 0;
		int tmp_row = 0;
		int tmp_col = 0;
		for (num = 0; num < row * col; num++) {

			numArr[tmp_row][tmp_col] = num;
			
			if (pivot % 4 == 0 && tmp_col >= col-turn_num-1) {
				pivot = 1;
			} else if (pivot % 4 == 1 && tmp_row >= row-turn_num-1) {
				pivot = 2;
			} else if (pivot % 4 == 2 && tmp_col <= turn_num) {
				turn_num++;
				pivot = 3;
			} else if (pivot % 4 == 3 && tmp_row <= turn_num) {
				pivot = 0;
			}
			
			switch (pivot % 4) {
			case 0:
				tmp_col++;
				break;
			case 1:
				tmp_row++;
				break;
			case 2:
				tmp_col--;
				break;
			case 3:
				tmp_row--;
			}
			
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.printf(numArr[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}
}
