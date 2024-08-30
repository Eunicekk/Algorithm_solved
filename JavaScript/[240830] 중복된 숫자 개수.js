function solution(array, n) {
    var answer = 0;
    
    for (const item of array) {
        if (item === n) answer++;
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.06ms, 33.4MB)
// 테스트 2 〉	통과 (0.06ms, 33.6MB)
// 테스트 3 〉	통과 (0.04ms, 33.5MB)
// 테스트 4 〉	통과 (0.14ms, 33.5MB)
// 테스트 5 〉	통과 (0.12ms, 33.5MB)
// 테스트 6 〉	통과 (0.04ms, 33.4MB)
