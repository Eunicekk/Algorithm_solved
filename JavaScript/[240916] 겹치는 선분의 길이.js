function solution(lines) {
    const arr = Array(201).fill(0);
    
    for (const [start, end] of lines) {
        for (let i = start + 100; i < end + 100; i++) {
            arr[i]++;
        }
    }

    let total = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > 1) {
            total++;
        }
    }

    return total;
}

// 테스트 1 〉	통과 (0.17ms, 33.5MB)
// 테스트 2 〉	통과 (0.17ms, 33.5MB)
// 테스트 3 〉	통과 (0.16ms, 33.4MB)
// 테스트 4 〉	통과 (0.17ms, 33.5MB)
// 테스트 5 〉	통과 (0.17ms, 33.4MB)
// 테스트 6 〉	통과 (0.16ms, 33.4MB)
// 테스트 7 〉	통과 (0.16ms, 33.5MB)
// 테스트 8 〉	통과 (0.18ms, 33.4MB)
// 테스트 9 〉	통과 (0.17ms, 33.4MB)
// 테스트 10 〉	통과 (0.16ms, 33.4MB)
