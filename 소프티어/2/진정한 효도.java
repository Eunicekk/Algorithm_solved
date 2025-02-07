package softeer;

import java.util.*;
import java.io.*;

public class Main_진정한효도 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] ground = new int[3][3];
		
		for (int r = 0; r < 3; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < 3; c++) {
				ground[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			int cost = 0;
			
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == k) continue;
					cost += Math.abs(ground[i][j] - ground[i][k]);
				}
				
				min = Math.min(min, cost);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			int cost = 0;
			
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == k) continue;
					cost += Math.abs(ground[j][i] - ground[k][i]);
				}
				
				min = Math.min(min, cost);
			}
		}

		System.out.println(min);
	}
	
}
