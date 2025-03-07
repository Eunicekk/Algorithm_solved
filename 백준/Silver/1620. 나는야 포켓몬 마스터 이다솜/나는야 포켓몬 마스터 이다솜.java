import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			map1.put(name, i);
			map2.put(i, name);
		}
		
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			
			if (temp.contains("0") || temp.contains("1") || temp.contains("2") || temp.contains("3") || temp.contains("4") || temp.contains("5") || temp.contains("6") || temp.contains("7") || temp.contains("8") || temp.contains("9")) {
				int key = Integer.parseInt(temp);
				System.out.println(map2.get(key));
			} else {
				System.out.println(map1.get(temp));
			}
		}
	}
	
}
