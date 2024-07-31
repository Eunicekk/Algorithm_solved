function solution(my_string) {
    var answer = '';
    var array = my_string.split("");
    
    for (let item of array) {
        if (item === item.toUpperCase()) {
            item = item.toLowerCase();
        } else {
            item = item.toUpperCase();
        }
        
        answer += item;
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.16ms, 33.5MB)
// 테스트 2 〉	통과 (0.15ms, 33.5MB)
// 테스트 3 〉	통과 (0.16ms, 33.5MB)
// 테스트 4 〉	통과 (0.22ms, 33.4MB)
// 테스트 5 〉	통과 (0.33ms, 33.7MB)
// 테스트 6 〉	통과 (0.35ms, 33.7MB)
// 테스트 7 〉	통과 (0.38ms, 33.6MB)
