import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 직사각형 네개의 합집합의 면적 구하기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] array = new int[100][100];
		int count = 0;
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if (x1 > x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}
			
			if (y1 > y2) {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}
			
			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++) {
					array[r][c] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (array[i][j] == 1) {
					count++;
				}
			}
		}
		
		bw.write(count + "");
		bw.close();
	}
	
}