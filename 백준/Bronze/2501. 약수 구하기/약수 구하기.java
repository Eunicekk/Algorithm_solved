import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 약수 구하기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				list.add(i);
			}
		}
		
		if (K > list.size()) {
			bw.write("0");
		} else {
			bw.write(String.format("%d", list.get(K-1)));
		}
		bw.close();
	} 
	
}