function solution(N, stages) {
    let result = [];
    let users = stages.length;
    
    for (let stage = 1; stage <= N; stage++) {
        const count = stages.filter(s => s === stage).length;
        const failure = users > 0 ? count / users : 0;
        result.push({stage, failure});
        users -= count;
    }

    result.sort((a, b) => {
        if (a.failure === b.failure) {
            return a.stage - b.stage;
        }
        
        return b.failure - a.failure;
    })
    
    return result.map(x => x.stage);
}

// 테스트 1 〉	통과 (0.22ms, 33.6MB)
// 테스트 2 〉	통과 (0.46ms, 33.6MB)
// 테스트 3 〉	통과 (66.30ms, 36.4MB)
// 테스트 4 〉	통과 (324.76ms, 38.4MB)
// 테스트 5 〉	통과 (1343.37ms, 42.1MB)
// 테스트 6 〉	통과 (2.20ms, 35.4MB)
// 테스트 7 〉	통과 (13.80ms, 36MB)
// 테스트 8 〉	통과 (339.35ms, 38.3MB)
// 테스트 9 〉	통과 (1343.86ms, 42.3MB)
// 테스트 10 〉	통과 (133.38ms, 38.3MB)
// 테스트 11 〉	통과 (342.59ms, 38.4MB)
// 테스트 12 〉	통과 (218.93ms, 38.9MB)
// 테스트 13 〉	통과 (556.37ms, 39.3MB)
// 테스트 14 〉	통과 (0.27ms, 33.7MB)
// 테스트 15 〉	통과 (15.89ms, 37.2MB)
// 테스트 16 〉	통과 (7.81ms, 37.9MB)
// 테스트 17 〉	통과 (16.86ms, 38.8MB)
// 테스트 18 〉	통과 (9.40ms, 37.8MB)
// 테스트 19 〉	통과 (3.14ms, 35.6MB)
// 테스트 20 〉	통과 (13.98ms, 39.3MB)
// 테스트 21 〉	통과 (23.59ms, 39.3MB)
// 테스트 22 〉	통과 (1398.46ms, 44.2MB)
// 테스트 23 〉	통과 (24.43ms, 43.5MB)
// 테스트 24 〉	통과 (79.15ms, 41.6MB)
// 테스트 25 〉	통과 (0.11ms, 33.6MB)
// 테스트 26 〉	통과 (0.13ms, 33.5MB)
// 테스트 27 〉	통과 (0.09ms, 33.5MB)
