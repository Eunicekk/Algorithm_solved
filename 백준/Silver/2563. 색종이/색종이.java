import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 색종이
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] white = new int[101][101];
		int answer = 0;
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for (int a = A; a < A+10; a++) {
				for (int b = B; b < B+10; b++) {
					white[a][b]++;
				}
			}
		}
		
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (white[i][j] != 0) {
					answer++;
				}
			}
		}
		
		bw.write(answer + "");
		bw.close();
	}
	
}