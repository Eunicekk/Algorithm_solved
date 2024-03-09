import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 소수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int count;
		int sum = 0;
		
		if (M <= 2 && N >= 2) { // 2가 포함되어야 할 때 2를 무조건 집어넣기
			list.add(2);
		}
		
		if (M % 2 == 0) { // 짝수일 때
			for (int i = M + 1; i <= N; i += 2) {
				count = 0;
				for (int j = 1; j <= i; j += 2) {
					if (i % j == 0) {
						count++;
					}
				}
				
				if (count == 2) {
					list.add(i);
				}
			}
		} else { // 홀수일 때
			for (int i = M; i <= N; i += 2) {
				count = 0;
				for (int j = 1; j <= i; j += 2) {
					if (i % j == 0) {
						count++;
					}
				}
				
				if (count == 2) {
					list.add(i);
				}
			}
		}
		
		if (list.isEmpty()) {
			bw.write("-1");
		} else {
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
			
			bw.write(sum + "\n");
			bw.write(String.format("%d", list.get(0)));
		}
		
		bw.close();
	}
	
}