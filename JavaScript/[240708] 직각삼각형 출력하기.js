const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    let n = Number(input[0]);
    for (let i = 0; i < n; i++) {
        console.log("*".repeat(i+1));
    }
});

// 테스트 1 〉	통과 (64.40ms, 32.2MB)
// 테스트 2 〉	통과 (60.36ms, 32.2MB)
// 테스트 3 〉	통과 (49.73ms, 32.2MB)
// 테스트 4 〉	통과 (43.20ms, 32.3MB)
// 테스트 5 〉	통과 (45.59ms, 32.3MB)
// 테스트 6 〉	통과 (48.10ms, 32.3MB)
// 테스트 7 〉	통과 (50.28ms, 32.2MB)
// 테스트 8 〉	통과 (48.74ms, 32.3MB)
// 테스트 9 〉	통과 (66.48ms, 32.3MB)
// 테스트 10 〉	통과 (64.53ms, 32.4MB)
