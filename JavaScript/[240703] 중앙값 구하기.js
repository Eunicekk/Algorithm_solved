function solution(array) {
    array.sort((a, b) => a - b)
    var mid = parseInt(array.length / 2);
    return array[mid];
}

// 테스트 1 〉	통과 (0.07ms, 33.3MB)
// 테스트 2 〉	통과 (0.05ms, 33MB)
// 테스트 3 〉	통과 (0.04ms, 33.4MB)
// 테스트 4 〉	통과 (0.05ms, 32.9MB)
// 테스트 5 〉	통과 (0.04ms, 33.4MB)
// 테스트 6 〉	통과 (0.09ms, 33.1MB)
// 테스트 7 〉	통과 (0.06ms, 33.2MB)
// 테스트 8 〉	통과 (0.06ms, 33.5MB)
// 테스트 9 〉	통과 (0.04ms, 33.4MB)
