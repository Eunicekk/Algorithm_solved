package softeer;

import java.util.*;
import java.io.*;

public class Main_8단변속기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		
		if (first == 1) {
			for (int i = 1; i < 8; i++) {
				int next = Integer.parseInt(st.nextToken());
				
				if (first < next) {
					first = next;
				} else {
					System.out.println("mixed");
					return;
				}
			}
			
			System.out.println("ascending");
		} else if (first == 8) {
			for (int i = 1; i < 8; i++) {
				int next = Integer.parseInt(st.nextToken());
				
				if (first > next) {
					first = next;
				} else {
					System.out.println("mixed");
					return;
				}
			}
			
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
	
}
