function solution(dots) {
    let x = new Set();
    let y = new Set();

    for (const item of dots) {
        x.add(item[0]);
        y.add(item[1]);
    }
    
    let arrayX = Array.from(x);
    let arrayY = Array.from(y);
    
    return Math.abs(arrayX[0] - arrayX[1]) * Math.abs(arrayY[0] - arrayY[1]);
}

// 테스트 1 〉	통과 (0.05ms, 33.5MB)
// 테스트 2 〉	통과 (0.05ms, 33.6MB)
// 테스트 3 〉	통과 (0.05ms, 33.5MB)
// 테스트 4 〉	통과 (0.05ms, 33.5MB)
// 테스트 5 〉	통과 (0.05ms, 33.5MB)
