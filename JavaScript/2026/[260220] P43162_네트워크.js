function solution(n, computers) {
    let result = 0;
    let visit = new Array(n).fill(false);
    
    const bfs = (start) => {
        let queue = [start];
        visit[start] = true;
        
        while (queue.length > 0) {
            let node = queue.shift();
            
            for (let i = 0; i < n; i++) {
                if (computers[node][i] === 1 && !visit[i]) {
                    visit[i] = true;
                    queue.push(i);
                }
            }
        }
    }
    
    for (let i = 0; i < n; i++) {
        if (!visit[i]) {
            bfs(i);
            result++;
        }
    }
    
    return result;
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.20ms, 33.5MB)
// 테스트 2 〉	통과 (0.17ms, 33.4MB)
// 테스트 3 〉	통과 (0.19ms, 33.4MB)
// 테스트 4 〉	통과 (0.30ms, 33.4MB)
// 테스트 5 〉	통과 (0.11ms, 33.4MB)
// 테스트 6 〉	통과 (0.40ms, 33.5MB)
// 테스트 7 〉	통과 (0.18ms, 33.5MB)
// 테스트 8 〉	통과 (0.38ms, 33.5MB)
// 테스트 9 〉	통과 (0.36ms, 33.4MB)
// 테스트 10 〉	통과 (0.31ms, 33.5MB)
// 테스트 11 〉	통과 (0.44ms, 33.7MB)
// 테스트 12 〉	통과 (0.38ms, 33.6MB)
// 테스트 13 〉	통과 (0.44ms, 33.5MB)
