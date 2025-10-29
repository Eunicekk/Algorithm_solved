function solution(rows, columns, queries) {
    let index = 1;
    let array = Array.from({length: rows}, () => Array.from({length: columns}, () => index++));
    let result = [];
    
    queries.forEach((query) => {
        let [sr, sc, dr, dc] = query.map(value => value - 1);
        let start = array[sr][sc];
        let min = Infinity;
        
        // 상단 이동
        for (let r = sr; r < dr; r++) {
            let prev = array[r + 1][sc];
            array[r][sc] = prev;
            min = Math.min(min, array[r][sc]);
        }
        
        // 우측 이동
        for (let c = sc; c < dc; c++) {
            let prev = array[dr][c + 1];
            array[dr][c] = prev;
            min = Math.min(min, array[dr][c]);
        }
        
        // 하단 이동
        for (let r = dr; r > sr; r--) {
            let prev = array[r - 1][dc];
            array[r][dc] = prev;
            min = Math.min(min, array[r][dc]);
        }
        
        // 좌측 이동
        for (let c = dc; c > sc; c--) {
            if (c - 1 === sc) {
                array[sr][c] = start;
            } else {
                let prev = array[sr][c - 1];
                array[sr][c] = prev;
            }
            
            min = Math.min(min, array[sr][c]);
        }

        result.push(min);
    })
    
    return result;
}

// 테스트 1 〉	통과 (0.40ms, 33.4MB)
// 테스트 2 〉	통과 (0.38ms, 33.5MB)
// 테스트 3 〉	통과 (24.29ms, 41.8MB)
// 테스트 4 〉	통과 (21.61ms, 40.9MB)
// 테스트 5 〉	통과 (49.40ms, 41MB)
// 테스트 6 〉	통과 (26.81ms, 42.3MB)
// 테스트 7 〉	통과 (29.66ms, 43.1MB)
// 테스트 8 〉	통과 (21.43ms, 41MB)
// 테스트 9 〉	통과 (22.27ms, 42.4MB)
// 테스트 10 〉	통과 (30.20ms, 42.1MB)
// 테스트 11 〉	통과 (24.18ms, 41.2MB)
