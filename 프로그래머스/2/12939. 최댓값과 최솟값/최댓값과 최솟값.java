class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] temp = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < temp.length; i++) {
            max = Math.max(max, Integer.parseInt(temp[i]));
            min = Math.min(min, Integer.parseInt(temp[i]));
        }
        
        answer = min + " " + max; 
        
        return answer;
    }
}