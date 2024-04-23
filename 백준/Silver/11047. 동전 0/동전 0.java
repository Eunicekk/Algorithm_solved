import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 0
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] money = new int[N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		while (K != 0) {
			for (int i = N-1; i >= 0; i--) {
				if (K >= money[i]) {
					K -= money[i];
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
	
}
