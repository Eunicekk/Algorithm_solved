function solution(cipher, code) {
    var answer = '';
    var array = cipher.split("");

    for (let i = 0; i < array.length; i++) {
        if ((i + 1) % code === 0) answer += array[i];
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.12ms, 33.5MB)
// 테스트 2 〉	통과 (0.12ms, 33.5MB)
// 테스트 3 〉	통과 (0.11ms, 33.5MB)
// 테스트 4 〉	통과 (0.04ms, 33.5MB)
// 테스트 5 〉	통과 (0.04ms, 33.5MB)
// 테스트 6 〉	통과 (0.15ms, 33.5MB)
// 테스트 7 〉	통과 (0.29ms, 33.6MB)
// 테스트 8 〉	통과 (0.19ms, 33.6MB)
// 테스트 9 〉	통과 (0.21ms, 33.5MB)
// 테스트 10 〉	통과 (0.16ms, 33.4MB)
// 테스트 11 〉	통과 (0.13ms, 33.5MB)
