import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 영화감독 숌
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		
		int value = 665;
		int answer = 0;
		
		while (true) {
			String temp = ++value + "";
			if (temp.contains("666")) {
				list.add(Integer.parseInt(temp));
			}
			
			if (list.size() == N) {
				answer = list.get(N - 1);
				break;
			}
		}
		
		System.out.println(answer);
	}
	
}