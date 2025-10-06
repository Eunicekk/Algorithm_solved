const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const n = Number(input);
let queens = [];
let result = 0;

function possible(x, y) {
  for (let [a, b] of queens) {
    if (a == x || b == y) {
      return false;
    }

    if (Math.abs(a - x) == Math.abs(b - y)) {
      return false;
    }
  }

  return true;
}

function dfs(depth) {
  if (depth === n) {
    result++;
    return;
  }

  for (let i = 0; i < n; i++) {
    if (!possible(depth, i)) {
      continue;
    }

    queens.push([depth, i]);
    dfs(depth + 1);
    queens.pop();
  }
}

dfs(0);
console.log(result);
