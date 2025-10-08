const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const k = Number(input[0]);
const signs = input[1].split(" ");

let visit = new Array(10).fill(false);
let result = [];

function check(a, b, op) {
  if (op === "<") {
    return a < b;
  }

  if (op === ">") {
    return a > b;
  }

  return false;
}

function dfs(depth, array) {
  if (depth === k + 1) {
    result.push(array.join(""));
    return;
  }

  for (let i = 0; i <= 9; i++) {
    if (visit[i]) {
      continue;
    }

    if (depth === 0 || check(array[depth - 1], i, signs[depth - 1])) {
      visit[i] = true;
      dfs(depth + 1, [...array, i]);
      visit[i] = false;
    }
  }
}

dfs(0, []);

result.sort();
console.log(result[result.length - 1]);
console.log(result[0]);
