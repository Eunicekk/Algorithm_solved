import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 딱지놀이
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 라운드 수
		int[][] A = new int[N][5];
		int[][] B = new int[N][5];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < num; j++) {
				int index = Integer.parseInt(st.nextToken());
				A[i][index]++;
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int num2 = Integer.parseInt(st2.nextToken());
			
			for (int j = 0; j < num2; j++) {
				int index = Integer.parseInt(st2.nextToken());
				B[i][index]++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (A[i][4] > B[i][4]) {
				bw.write("A" + "\n");
				continue;
			} else if (A[i][4] < B[i][4]) {
				bw.write("B" + "\n");
				continue;
			}
			
			if (A[i][3] > B[i][3]) {
				bw.write("A" + "\n");
				continue;
			} else if (A[i][3] < B[i][3]) {
				bw.write("B" + "\n");
				continue;
			}
			
			if (A[i][2] > B[i][2]) {
				bw.write("A" + "\n");
				continue;
			} else if (A[i][2] < B[i][2]) {
				bw.write("B" + "\n");
				continue;
			}
			
			if (A[i][1] > B[i][1]) {
				bw.write("A" + "\n");
				continue;
			} else if (A[i][1] < B[i][1]) {
				bw.write("B" + "\n");
				continue;
			}
			
			bw.write("D" + "\n");
		}
		
		bw.close();
		
	}
	
}