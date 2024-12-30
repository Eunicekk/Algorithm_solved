import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for (String id : id_list) {
            reports.put(id, new HashSet<>());
            count.put(id, 0);
            mail.put(id, 0);
        }
        
        for (String r : report) {
            String[] part = r.split(" ");
            String reporter = part[0];
            String reported = part[1];
            
            if (reports.get(reporter).add(reported)) {
                count.put(reported, count.get(reported) + 1);
            }
        }

        for (String reported : count.keySet()) {
            if (count.get(reported) >= k) {
                for (String reporter : id_list) {
                    if (reports.get(reporter).contains(reported)) {
                        mail.put(reporter, mail.get(reporter) + 1);
                    }
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }
        
        return answer;
    }
}