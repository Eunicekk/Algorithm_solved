function solution(keyinput, board) {
    let answer = [];
    let start = [0, 0];
    let boundary = [parseInt(board[0]) / 2, parseInt(board[1] / 2)];
 
    for (const item of keyinput) {
        if (item === "up") {
            if (Math.abs(start[1] + 1) <= boundary[1]) {
                start[1] += 1;
            }
        } else if (item === "down") {
            if (Math.abs(start[1] - 1) <= boundary[1]) {
                start[1] -= 1;
            }
        } else if (item === "left") {
            if (Math.abs(start[0] - 1) <= boundary[0]) {
                start[0] -= 1;
            }
        } else if (item === "right") {
            if (Math.abs(start[0] + 1) <= boundary[0]) {
                start[0] += 1;
            }
        }
    }
    
    return start;
}

// 테스트 1 〉	통과 (0.08ms, 33.4MB)
// 테스트 2 〉	통과 (0.12ms, 33.5MB)
// 테스트 3 〉	통과 (0.09ms, 33.4MB)
// 테스트 4 〉	통과 (0.12ms, 33.4MB)
// 테스트 5 〉	통과 (0.07ms, 33.5MB)
// 테스트 6 〉	통과 (0.09ms, 33.3MB)
// 테스트 7 〉	통과 (0.21ms, 33.5MB)
// 테스트 8 〉	통과 (0.23ms, 33.3MB)
// 테스트 9 〉	통과 (0.17ms, 33.5MB)
// 테스트 10 〉	통과 (0.11ms, 33.5MB)
// 테스트 11 〉	통과 (0.08ms, 33.4MB)
