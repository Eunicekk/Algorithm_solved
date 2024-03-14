import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 체스판 다시 칠하기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char [][] whole = new char[N][M];
		char[][] chess = new char[8][8];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				whole[i][j] = temp.charAt(j);
			}
		}
		
		int index = 0;
		int jndex = 0;
		
		int colorB = 0;
		int colorW = 0;
		int color = 0;
		int minColor = Integer.MAX_VALUE;
		
		while (true) {
			colorB = 0;
			colorW = 0;
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					chess[i][j] = whole[index + i][jndex + j];
					
					if (chess[0][0] == 'B' ) {
						if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
							if (chess[i][j] != 'B') {
								colorB++;
							}
						} else {
							if (chess[i][j] != 'W') {
								colorB++;
							}
						}
						
						if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
							if (chess[i][j] != 'W') {
								colorW++;
							}
						} else {
							if (chess[i][j] != 'B') {
								colorW++;
							}
						}
						
						color = Math.min(colorB, colorW);
					} else {
						if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
							if (chess[i][j] != 'W') {
								colorW++;
							}
						} else {
							if (chess[i][j] != 'B') {
								colorW++;
							}
						}
						
						if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
							if (chess[i][j] != 'B') {
								colorB++;
							}
						} else {
							if (chess[i][j] != 'W') {
								colorB++;
							}
						}
						
						color = Math.min(colorB, colorW);
					}
				}
			}

			minColor = Math.min(color, minColor);
			jndex++;

			if (jndex + 8 > M) {
				jndex = 0;
				index++;
				if (index + 8 > N) {
					break;
				}
			}
		}
		
		bw.write(minColor + "");
		bw.close();
		
	}
	
}