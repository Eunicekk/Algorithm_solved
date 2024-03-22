import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그대로 출력하기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder str = new StringBuilder();
		
		while (true) {
			String temp = br.readLine();
			if (temp == null || temp.isEmpty()) {
				break;
			}
			str.append(temp).append("\n");
		}
		
		br.close();
		System.out.println(str);
	}
	
}