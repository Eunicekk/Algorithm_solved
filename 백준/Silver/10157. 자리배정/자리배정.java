import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 자리배정
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // 가로
		int R = Integer.parseInt(st.nextToken()); // 세로
		long N = Integer.parseInt(br.readLine()); // 대기 번호표
		int[][] seat = new int[C][R];
		
		// 델타 (우 하 좌 상)
		int[] dc = {0, 1, 0, -1};
		int[] dr = {1, 0, -1, 0};
		
		int num = 1;
		int d = 0;
		int c = 0;
		int r = 0;
		
		while (true) {
			seat[c][r] = num;
			
			if (num == C * R) {
				break;
			}
			
			c = c + dc[d];
			r = r + dr[d];
			
			if (r < R && c < C && r >= 0 && c >= 0 && seat[c][r] == 0) {
				num++;
			} else {
				c -= dc[d];
				r -= dr[d];
				d = (d + 1) % 4;
			}
		}
		
		int ar = -1, ac = -1;
		
		out : for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (seat[i][j] == N) {
					ac = i + 1;
					ar = j + 1;
					break out;
				}
			}
		}
		
		if (ar >= 0 && ac >= 0) {
			bw.write(ac + " " + ar);
		} else {
			bw.write("0");
		}
		bw.close();
	}
	
}