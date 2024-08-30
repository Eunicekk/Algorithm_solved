function solution(array, height) {
    var answer = 0;
    
    for (const item of array) {
        if (height < item) answer++;
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.04ms, 33.4MB)
// 테스트 2 〉	통과 (0.04ms, 33.4MB)
// 테스트 3 〉	통과 (0.06ms, 33.4MB)
// 테스트 4 〉	통과 (0.17ms, 33.5MB)
