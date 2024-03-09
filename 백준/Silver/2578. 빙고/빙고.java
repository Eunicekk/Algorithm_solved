import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 빙고
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] bingo = new int[5][5];
		int[][] mc = new int[5][5];
		int count = 0;
		int cross1 = 0;
		int cross2 = 0;
		
		int index = 0;
		int jndex = 0;
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				mc[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bingo : for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int garo = 0;
				int sero = 0;
				int dr = 0;
				int dc = 0;
				
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (mc[i][j] == bingo[r][c]) {
							bingo[r][c] = 0;
							dr = r;
							dc = c;
						}
					}
				}
				
				// 가로 확인
				for (int k = 0; k < 5; k++) {
					if (bingo[dr][k] == 0) {
						garo++;
					}
				}
				
				if (garo == 5) {
					count++;
				}
				
				// 새로 확인
				for (int k = 0; k < 5; k++) {
					if (bingo[k][dc] == 0) {
						sero++;
					}
				}
				
				if (sero == 5) {
					count++;
				}
				
				// 대각선 확인
				if (cross1 != 5) {
					cross1 = 0;
					
					for (int k = 0; k < 5; k++) {
						if (bingo[k][k] == 0) {
							cross1++;
						}
					}
					
					if (cross1 == 5) {
						count++;
					}
				}
				
				if (cross2 != 5) {
					cross2 = 0;
					
					for (int k = 0; k < 5; k++) {
						if (bingo[k][4 - k] == 0) {
							cross2++;
						}
					}
					
					if (cross2 == 5) {
						count++;
					}
				}
				
				if (count >= 3) {
					index = i;
					jndex = j;
					break bingo;
				}
			}
		}
		
		bw.write(5 * index + jndex + 1 + "");
		bw.close();
	}
	
}
