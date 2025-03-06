import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) + 1);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		
		list.sort((a, b) -> {
			if (!a.getValue().equals(b.getValue())) {
				return b.getValue() - a.getValue();
			}
			
			return a.getKey().compareTo(b.getKey());
		});
		
		System.out.println(list.get(0).getKey());
	}
	
}
