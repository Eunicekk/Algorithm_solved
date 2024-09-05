function solution(board) {
    let dr = [-1, 1, 0, 0, -1, -1, 1, 1];
    let dc = [0, 0, -1, 1, -1, 1, -1, 1];
    let count = 0;
    
    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board.length; c++) {
            if (board[r][c] === 1) {
                for (let i = 0; i < 8; i++) {
                    let nr = r + dr[i];
                    let nc = c + dc[i];
                    
                    if (nr >= 0 && nr < board.length && nc >= 0 && nc < board.length && board[nr][nc] !== 1) {
                        board[nr][nc] -= 1;
                    }
                }
            }
        }
    }
    
    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board.length; c++) {
            if (board[r][c] === 0) count++;
        }
    }
    
    return count;
}


// 테스트 1 〉	통과 (0.17ms, 33.4MB)
// 테스트 2 〉	통과 (0.14ms, 33.4MB)
// 테스트 3 〉	통과 (0.18ms, 33.5MB)
// 테스트 4 〉	통과 (0.27ms, 33.4MB)
// 테스트 5 〉	통과 (0.24ms, 33.5MB)
// 테스트 6 〉	통과 (0.25ms, 33.5MB)
// 테스트 7 〉	통과 (0.20ms, 33.4MB)
// 테스트 8 〉	통과 (0.06ms, 33.5MB)
// 테스트 9 〉	통과 (0.11ms, 33.4MB)
// 테스트 10 〉	통과 (0.10ms, 33.4MB)
// 테스트 11 〉	통과 (0.07ms, 33.5MB)
// 테스트 12 〉	통과 (0.22ms, 33.5MB)
// 테스트 13 〉	통과 (0.16ms, 33.4MB)
// 테스트 14 〉	통과 (0.22ms, 33.4MB)
