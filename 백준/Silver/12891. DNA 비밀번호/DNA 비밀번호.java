import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DNA 비밀번호
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
		String text = br.readLine();
		
		int[] count = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] check = new int[4];
		int answer = 0;
		
		for (int i = 0; i < P; i++) {
			if (text.charAt(i) == 'A') {
				check[0]++;
			} else if (text.charAt(i) == 'C') {
				check[1]++;
			} else if (text.charAt(i) == 'G') {
				check[2]++;
			} else if (text.charAt(i) == 'T') {
				check[3]++;
			}
		}
		
		int isCheck = 0;
		for (int i = 0; i < 4; i++) {
			if (count[i] > check[i]) isCheck++;
		}
		if (isCheck == 0) answer++; 
		
		int s = 0;
		int f = P;
		
		out: while (f < S) {
			if (text.charAt(s) == 'A') {
				check[0]--;
			} else if (text.charAt(s) == 'C') {
				check[1]--;
			} else if (text.charAt(s) == 'G') {
				check[2]--;
			} else if (text.charAt(s) == 'T') {
				check[3]--;
			}
			
			if (text.charAt(f) == 'A') {
				check[0]++;
			} else if (text.charAt(f) == 'C') {
				check[1]++;
			} else if (text.charAt(f) == 'G') {
				check[2]++;
			} else if (text.charAt(f) == 'T') {
				check[3]++;
			}
			
			s++;
			f++;
			
			for (int i = 0; i < 4; i++) {
				if (count[i] > check[i]) continue out;
			}
			answer++;
		}
		
		System.out.println(answer);
	}
	
}
