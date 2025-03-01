import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> names = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for (String text : record) {
            String command = text.split(" ")[0];
            String id = text.split(" ")[1];
            
            if (command.equals("Enter") || command.equals("Change")) {
                String name = text.split(" ")[2];
                names.put(id, name);
            }
        }
        
        for (String text : record) {
            String command = text.split(" ")[0];
            String id = text.split(" ")[1];
            
            if (command.equals("Enter")) {
                list.add(names.get(id) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                list.add(names.get(id) + "님이 나갔습니다.");
            }                
        }
        
        String[] answer = list.toArray(new String[0]);
        
        return answer;
    }
}