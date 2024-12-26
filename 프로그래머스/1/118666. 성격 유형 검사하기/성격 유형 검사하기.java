import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] array = {"R", "T", "C", "F", "J", "M", "A", "N"};
        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        
        String answer = "";
        int length = survey.length;
        
        for (int l = 0; l < length; l++) {
            String left = survey[l].split("")[0];
            String right = survey[l].split("")[1];
            int score = choices[l] - 4;
            
            if (score < 0) {
                int old = map.get(left);
                map.replace(left, old + Math.abs(score));
            } else if (score > 0) {
                int old = map.get(right);
                map.replace(right, old + Math.abs(score));
            }
        }
        
        for (int i = 0; i < 8; i += 2) {
            if (map.get(array[i]) >= map.get(array[i+1])) {
                answer += array[i];
            } else {
                answer += array[i+1];
            } 
        }
        
        return answer;
    }
}