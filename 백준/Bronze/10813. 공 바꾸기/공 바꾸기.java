import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 공 바꾸기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 바구니 개수
		int M = Integer.parseInt(st.nextToken()); // 바꾸는 횟수
		int[] basket = new int[N+1];
		
		// 바구니에 값 넣기
		for (int i = 1; i <= N; i++) {
			basket[i] = i;
		}
		
		// 공 바꾸기
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st2.nextToken());
			int right = Integer.parseInt(st2.nextToken());
			int temp = basket[left];
			basket[left] = basket[right];
			basket[right] = temp;
		}
		
		for (int i = 1; i <= N; i++) {
			bw.write(basket[i] + " ");
		}
		bw.close();
	}
	
}