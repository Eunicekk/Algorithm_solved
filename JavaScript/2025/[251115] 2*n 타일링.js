const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

let n = Number(input);
let dp = Array(n + 1).fill(0);

if (n === 1) {
  console.log(1);
  return;
}

if (n === 2) {
  console.log(2);
  return;
}

dp[1] = 1;
dp[2] = 2;

for (let i = 3; i < n + 1; i++) {
  dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
}

console.log(dp[n]);
