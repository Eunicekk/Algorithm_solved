function solution(my_string, n) {
    var array = my_string.split("");
    var answer = '';
    
    for (const item of array) {
        answer += item.repeat(n);
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.07ms, 33.4MB)
// 테스트 2 〉	통과 (0.05ms, 33.4MB)
// 테스트 3 〉	통과 (0.04ms, 33.4MB)
// 테스트 4 〉	통과 (0.04ms, 33.4MB)
