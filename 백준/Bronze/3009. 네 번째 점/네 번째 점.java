import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 네 번째 점
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] x = new int[3];
		int[] y = new int[3];
		
		int countX = 0;
		int countY = 0;
		int indexX = 0;
		int indexY = 0;
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < 3; i++) {
			if (x[0] != x[i]) {
				countX++;
				if (countX == 1) {
					indexX = i;
				} else {
					indexX = 0;
				}
			}
			
			if (y[0] != y[i]) {
				countY++;
				if (countY == 1) {
					indexY = i;
				} else {
					indexY = 0;
				}
			}
		}
		
		bw.write(x[indexX] + " " + y[indexY] + "\n");
		bw.close();
	}
	
}