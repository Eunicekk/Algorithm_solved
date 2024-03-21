import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = -1;
		
		if (N % 5 == 0) {
			count = N / 5;
		} else {
			int share = N / 5;
			int rest = N % 5;
			
			for (int s = share; s >= 0; s--) {
				if (rest % 3 == 0) {
					count = s + (rest / 3);
					break;
				} else {
					rest += 5;
				}
			}
		}
		
		System.out.println(count);
	}
	
}