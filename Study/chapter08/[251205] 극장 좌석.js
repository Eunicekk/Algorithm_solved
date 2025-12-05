const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let m = Number(input[1]);
let vip = input.slice(2).map(Number);

let dp = Array(n + 1).fill(1);
dp[2] = 2;

for (let i = 3; i <= n; i++) {
  dp[i] = dp[i - 1] + dp[i - 2];
}

let prev = 0;
let result = 1;

for (let i = 0; i < m; i++) {
  let gap = vip[i] - prev - 1;
  result *= dp[gap];
  prev = vip[i];
}

let gap = n - prev;
result *= dp[gap];

console.log(result);
