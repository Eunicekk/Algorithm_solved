package softeer;

import java.util.*;
import java.io.*;

public class Main_비밀메뉴 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 비밀메뉴 조작법
		int N = Integer.parseInt(st.nextToken()); // 누른 번호 개수
		int K = Integer.parseInt(st.nextToken());

		String password = br.readLine();
		String click = br.readLine();
		
		if (N < M) {
			System.out.println("normal");
			return;
		}
		
		if (click.contains(password)) {
			System.out.println("secret");
		} else {
			System.out.println("normal");
		}
	}
	
}
