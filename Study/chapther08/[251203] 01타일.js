const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const mod = 15746;
let n = Number(input);

if (n === 1) {
  console.log(1);
  return;
}

if (n === 2) {
  console.log(2);
  return;
}

let dp = Array(n + 1).fill(0);

dp[1] = 1;
dp[2] = 2;

for (let i = 3; i <= n; i++) {
  dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
}

console.log(dp[n]);
