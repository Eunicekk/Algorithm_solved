const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const [n, m] = input.split(" ").map(Number);

let result = [];
let select = [];

function dfs(start, depth) {
  if (depth === m) {
    result.push(select.join(" "));
    return;
  }

  for (let i = start; i <= n; i++) {
      select.push(i);
      dfs(i, depth + 1);
      select.pop();
  }
}

dfs(1, 0);
console.log(result.join("\n"));
