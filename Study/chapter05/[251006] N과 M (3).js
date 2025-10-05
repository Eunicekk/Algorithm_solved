const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const [n, m] = input.split(" ").map(Number);

let result = [];
let select = [];

function dfs(depth) {
  if (depth === m) {
    result.push(select.join(" "));
    return;
  }

  for (let i = 1; i <= n; i++) {
    select.push(i);
    dfs(depth + 1);
    select.pop();
  }
}

dfs(0);
console.log(result.join("\n"));
