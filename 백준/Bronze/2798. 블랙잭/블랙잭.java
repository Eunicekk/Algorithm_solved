import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 블랙잭
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카드의 개수
		int M = Integer.parseInt(st.nextToken()); // 합 제한
		int[] cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		out: for (int i = 0; i < N-2; i++) {
			for (int j = i + 1; j < N-1; j++) {
				for (int k = j + 1; k < N; k++) {
					if (cards[i] + cards[j] + cards[k] > M) {
						continue;
					} else if (cards[i] + cards[j] + cards[k] == M) {
						answer = M;
						break out;
					} else {
						answer = Math.max(answer, cards[i] + cards[j] + cards[k]);
					}
				}
			}
		}
		
		bw.write(answer + "");
		bw.close();
	}
	
}