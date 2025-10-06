const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const cities = [];

for (let i = 1; i <= n; i++) {
  cities.push(input[i].split(" ").map(Number));
}

let visit = new Array(n).fill(false);
let result = Number.MAX_SAFE_INTEGER;

function dfs(start, now, depth, cost) {
  if (depth === n && cities[now][start] !== 0) {
    result = Math.min(result, cost + cities[now][start]);
    return;
  }

  for (let next = 0; next < n; next++) {
    if (!visit[next] && cities[now][next] !== 0) {
      visit[next] = true;
      dfs(start, next, depth + 1, cost + cities[now][next]);
      visit[next] = false;
    }
  }
}

visit[0] = true;
dfs(0, 0, 1, 0);
console.log(result);
