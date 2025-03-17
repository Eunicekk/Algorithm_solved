import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			if (str.equals("ENTER")) {
				count += set.size();
				set = new HashSet<>();
			} else {
				set.add(str);
			}
		}
		
		count += set.size();
		
		System.out.println(count);
	}
	
}
