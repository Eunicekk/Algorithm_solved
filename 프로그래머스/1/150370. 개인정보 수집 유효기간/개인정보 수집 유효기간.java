import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        String[] todayArray = today.split("\\.");
        Map<String, Integer> map = new HashMap<>();
        int length = privacies.length;
        
        for (String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for (int i = 0; i < length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            
            int addYear = map.get(privacy[1]) / 12;
            int addMonth = map.get(privacy[1]) % 12;
            
            int[] deadline = new int[3];
            deadline[0] = year + addYear;
            deadline[1] = month + addMonth;
            deadline[2] = day;
            
            if (deadline[1] > 12) {
                deadline[0] += deadline[1] / 12;
                deadline[1] = deadline[1] % 12;
            }
            
            int todayYear = Integer.parseInt(todayArray[0]);
            int todayMonth = Integer.parseInt(todayArray[1]);
            int todayDay = Integer.parseInt(todayArray[2]);

            if (deadline[0] < todayYear || 
                (deadline[0] == todayYear && deadline[1] < todayMonth) || 
                (deadline[0] == todayYear && deadline[1] == todayMonth && deadline[2] <= todayDay)) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            answer[index++] = iterator.next();
        }

        return answer;
    }
}