import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// N-Queen
public class Main {
	
	static int[] position;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 체스판 크기
		position = new int[N]; // 인덱스 : row, 값 : col
		count = 0;
		
		queen(0, N);
		
		bw.write(count + "");
		bw.close();
	}
	
	static boolean check(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (position[i] == col || Math.abs(i - row) == Math.abs(position[i] - col)) {
				return false;
			}
		}
		
		return true;
	}
	
	static void queen(int row, int n) {
		// 기저 조건
		if (row == n) {
			count++;
			return;
		}
		
		// 재귀 조건
		for (int i = 0; i < n; i++) {
			if (check(row, i)) {
				position[row] = i;
				queen(row + 1, n);
			}
		}
	}
}