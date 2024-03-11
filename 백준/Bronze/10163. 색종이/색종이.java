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
		
		int[][] total = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int r = x; r < x + w; r++) {
				for (int c = y; c < y + h; c++) {
					total[r][c] = i;
				}
			}
			
		}
		
		for (int i = 1; i <= N; i++) {
			int count = 0;
			
			for (int r = 0; r < 1001; r++) {
				for (int c = 0; c < 1001; c++) {
					if (total[r][c] == i) {
						count++;
					}
				}
			}
			
			bw.write(count + "\n");
		}
		
		bw.close();
		
	}
	
}
