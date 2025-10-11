function solution(board, moves) {
    const basket = [];
    let count = 0;
    
    for (let move of moves) {
        for (let i = 0; i < board.length; i++) {
            const doll = board[i][move - 1];
            
            if (doll !== 0) {
                board[i][move - 1] = 0;
                
                if (basket[basket.length - 1] === doll) {
                    basket.pop();
                    count += 2;
                } else {
                    basket.push(doll);
                }
                
                break;
            }
        }
    }
    
    return count;
}

// 테스트 1 〉	통과 (0.17ms, 32.8MB)
// 테스트 2 〉	통과 (0.18ms, 32.9MB)
// 테스트 3 〉	통과 (0.17ms, 33MB)
// 테스트 4 〉	통과 (22.60ms, 36MB)
// 테스트 5 〉	통과 (0.17ms, 32.8MB)
// 테스트 6 〉	통과 (0.17ms, 32.8MB)
// 테스트 7 〉	통과 (0.20ms, 33.1MB)
// 테스트 8 〉	통과 (0.29ms, 32.9MB)
// 테스트 9 〉	통과 (0.30ms, 32.9MB)
// 테스트 10 〉	통과 (0.31ms, 33MB)
// 테스트 11 〉	통과 (0.56ms, 33.1MB)
