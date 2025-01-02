class Solution {
    public int solution(String s) {
        int min = s.length();
        
        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, step);
            int count = 1;
            
            for (int i = step; i < s.length(); i += step) {
                String part = s.substring(i, Math.min(i + step, s.length()));
                
                if (prev.equals(part)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    prev = part;
                    count = 1;
                }
            }
            
            if (count > 1) sb.append(count);
            sb.append(prev);
            
            min  = Math.min(min, sb.length());
        }
        
        return min;
    }
}