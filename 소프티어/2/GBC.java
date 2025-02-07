package softeer;

import java.util.*;
import java.io.*;

public class Main_GBC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 원래 구간
		int M = Integer.parseInt(st.nextToken()); // 임의 구간
		int[][] sectionN = new int[N][2];
		int[][] sectionM = new int[M][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sectionN[i][0] = Integer.parseInt(st.nextToken()); // 길이
			sectionN[i][1] = Integer.parseInt(st.nextToken()); // 속도
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sectionM[i][0] = Integer.parseInt(st.nextToken()); // 길이
			sectionM[i][1] = Integer.parseInt(st.nextToken()); // 속도
		}
		
		int max = 0;
		int heightN = 0;
		int heightM = 0;
		int addN = 0;
		int addM = 0;
		int idxN = 0;
		int idxM = 0;
		
		for (int num = 0; num < 100; num++) {
			heightN = sectionN[idxN][0] + addN;
			heightM = sectionM[idxM][0] + addM;
			
			max = Math.max(max, sectionM[idxM][1] - sectionN[idxN][1]);
			
			if (num == heightN) {
				addN += sectionN[idxN][0];
				idxN++;
			}
			
			if (num == heightM) {
				addM += sectionM[idxM][0];
				idxM++;
			}
		}
		
		System.out.println(max);
	}
	
}
