function solution(brown, yellow) {
    let width = Math.ceil((brown / 2) / 2) + 1;
    let height = Math.floor((brown / 2) / 2) + 1;

    while (width * height !== brown + yellow) {
        width++;
        height--;
    }
    
    return [width, height];
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.04ms, 33.6MB)
// 테스트 2 〉	통과 (0.05ms, 33.5MB)
// 테스트 3 〉	통과 (0.06ms, 33.4MB)
// 테스트 4 〉	통과 (0.13ms, 33.4MB)
// 테스트 5 〉	통과 (0.14ms, 33.4MB)
// 테스트 6 〉	통과 (0.12ms, 33.4MB)
// 테스트 7 〉	통과 (0.12ms, 33.2MB)
// 테스트 8 〉	통과 (0.04ms, 33.4MB)
// 테스트 9 〉	통과 (0.18ms, 33.4MB)
// 테스트 10 〉	통과 (0.04ms, 33.5MB)
// 테스트 11 〉	통과 (0.04ms, 33.4MB)
// 테스트 12 〉	통과 (0.05ms, 33.5MB)
// 테스트 13 〉	통과 (0.04ms, 33.5MB)
