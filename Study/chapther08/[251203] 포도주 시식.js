const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let wine = [0, ...input.slice(1).map(Number)];

if (n === 1) {
  console.log(wine[1]);
  return;
}

if (n === 2) {
  console.log(wine[1] + wine[2]);
  return;
}

let dp = Array(n + 1).fill(0);

dp[1] = wine[1];
dp[2] = wine[1] + wine[2];

for (let i = 3; i <= n; i++) {
  dp[i] = Math.max(
    dp[i - 1],
    dp[i - 2] + wine[i],
    dp[i - 3] + wine[i - 1] + wine[i],
  );
}

console.log(dp[n]);
