function solution(s) {
    let count = {};
    let result = [];

    // 각 문자의 등장 횟수 계산
    for (let char of s) {
        count[char] = (count[char] || 0) + 1;
    }

    // 한 번만 등장한 문자 수집
    for (let char of s) {
        if (count[char] === 1) {
            result.push(char);
        }
    }

    // 사전 순으로 정렬 후 문자열로 반환
    return result.sort().join('');
}

// 테스트 1 〉	통과 (0.09ms, 31.7MB)
// 테스트 2 〉	통과 (0.18ms, 31.5MB)
// 테스트 3 〉	통과 (0.20ms, 33.4MB)
// 테스트 4 〉	통과 (0.23ms, 33.4MB)
// 테스트 5 〉	통과 (0.21ms, 33.4MB)
// 테스트 6 〉	통과 (0.06ms, 33.4MB)
// 테스트 7 〉	통과 (0.21ms, 33.4MB)
// 테스트 8 〉	통과 (0.08ms, 33.5MB)
// 테스트 9 〉	통과 (0.08ms, 33.4MB)
// 테스트 10 〉	통과 (0.09ms, 33.4MB)
