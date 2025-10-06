const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const tastes = [];

for (let i = 1; i <= n; i++) {
  tastes.push(input[i].split(" ").map(Number));
}

let result = Number.MAX_VALUE;

function dfs(depth, count, sour, bitter) {
  if (depth === n) {
    if (count > 0) {
      result = Math.min(result, Math.abs(sour - bitter));
    }
    return;
  }

  dfs(depth + 1, count + 1, sour * tastes[depth][0], bitter + tastes[depth][1]);
  dfs(depth + 1, count, sour, bitter);
}

dfs(0, 0, 1, 0);
console.log(result);
