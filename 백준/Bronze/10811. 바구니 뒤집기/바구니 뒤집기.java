import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 바구니 뒤집기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 바구니 개수
		int M = Integer.parseInt(st.nextToken()); // 바구니 교환 횟수
		int[] basket = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			basket[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int indexA = a;
			int indexB = b;
			
			// 역순으로 만드는 작업 (양끝교환하기)
			for (int j = 0; j < (b-a+1)/2; j++) {
				int temp = basket[indexA];
				basket[indexA] = basket[indexB];
				basket[indexB] = temp;
				indexA++;
				indexB--;
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			bw.write(basket[i] + " ");
		}
		
		bw.close();
	}
	
}