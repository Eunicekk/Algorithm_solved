import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        char[] array = new_id.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 65 && array[i] <= 90) {
                answer.append((char)(array[i] + 32));
            } else if ((array[i] < 48 || array[i] > 57) && (array[i] < 97 || array[i] > 122) && (array[i] != '-') && (array[i] != '_') && (array[i] != '.')) {
                continue;
            } else if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.' && array[i] == '.') {
                continue;
            } else {
                answer.append(array[i]);
            }
        }
        
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer.deleteCharAt(0);
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer.deleteCharAt(answer.length() - 1);
        }
        
        if (answer.length() == 0) {
            answer.append("a");
        }
        
        if (answer.length() >= 16) {
            answer.setLength(15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        
        if (answer.length() <= 2) {
            while (answer.length() != 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        }
        
        return answer.toString();
    }
}