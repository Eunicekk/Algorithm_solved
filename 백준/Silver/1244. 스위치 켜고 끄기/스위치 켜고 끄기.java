import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 스위치 켜고 끄기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		int[] button = new int[N + 1];
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			button[i] = Integer.parseInt(s.nextToken());
		}
		
		int P = Integer.parseInt(br.readLine()); // 사람 수
		
		for (int p = 0; p < P; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 1) {
				int index = Integer.parseInt(st.nextToken());
				
				for (int i = 1; i <= N; i++) {
					if (i % index == 0) {
						if (button[i] == 1) {
							button[i] = 0;
						} else {
							button[i] = 1;
						}
					}
				}
			} else {
				int index = Integer.parseInt(st.nextToken());
				
				if (button[index] == 1) {
					button[index] = 0;
				} else {
					button[index] = 1;
				}
				
				for (int i = 1; i <= N; i++) {
					if (index - i > 0 && index + i <= N) {
						if (button[index - i] == 1 && button[index + i] == 1) {
							button[index - i] = 0;
							button[index + i] = 0;
						} else if (button[index - i] == 0 && button[index + i] == 0) {
							button[index - i] = 1;
							button[index + i] = 1;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (i % 20 == 0) {
				bw.write(button[i] + "\n");
			} else {
				bw.write(button[i] + " ");
			}
		}
		
		bw.close();
	}
	
}