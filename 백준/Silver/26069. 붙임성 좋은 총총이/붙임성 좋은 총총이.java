import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		set.add("ChongChong");
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			if (set.contains(a) || set.contains(b)) {
				set.add(a);
				set.add(b);
			}
		}
		
		System.out.println(set.size());
	}
	
}
