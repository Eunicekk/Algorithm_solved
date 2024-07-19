function solution(my_string) {
    var array = my_string.split("");
    var answer = '';
    
    for (const item of array) {
        if (item !== 'a' && item !== 'e' && item !== 'i' && item !== 'o' && item !== 'u') {
            answer += item;
        }
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.05ms, 33.4MB)
// 테스트 2 〉	통과 (0.05ms, 33.4MB)
// 테스트 3 〉	통과 (0.05ms, 33.4MB)
// 테스트 4 〉	통과 (0.05ms, 33.4MB)
// 테스트 5 〉	통과 (0.13ms, 33.5MB)
// 테스트 6 〉	통과 (0.15ms, 33.5MB)
