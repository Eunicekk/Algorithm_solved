import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		String temp = "";
		int count = 0;
		
		if (Integer.parseInt(N) < 10) {
			temp = 0 + N;
		} else {
			temp = N;
		}
		
		do {
			String first = String.format("%c", temp.charAt(1));
			String second = "";

			int sum = (temp.charAt(0) - '0') + (temp.charAt(1) - '0');
			
			if (sum >= 10) {
				second += sum % 10;
			} else {
				second += sum;
			}
			
			temp = "";
			temp += first + second;
			count++;
		} while (Integer.parseInt(N) != Integer.parseInt(temp));
		
		sb.append(count + "");
		System.out.println(sb);
	}
	
}