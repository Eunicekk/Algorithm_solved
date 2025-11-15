const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let stair = [0, ...input.map(Number).slice(1)];
let dp = Array(n + 1).fill(0);

if (n === 1) {
  console.log(stair[1]);
  return;
}

dp[1] = stair[1];
dp[2] = stair[1] + stair[2];

if (n >= 3) {
  dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
}

for (let i = 4; i < n + 1; i++) {
  dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
}

console.log(dp[n]);
