import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        String temp = "";
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c + "";
            } else {
                temp += c + "";
                
                if (map.containsKey(temp)) {
                    answer += map.get(temp) + "";
                    temp = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}