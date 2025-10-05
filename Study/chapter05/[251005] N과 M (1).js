const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const n = Number(input[0]);
const m = Number(input[1]);

let visit = Array(n + 1).fill(false);
let result = [];
let select = [];

function dfs(depth) {
  if (depth === m) {
    result.push(select.join(" "));
    return;
  }

  for (let i = 1; i <= n; i++) {
    if (!visit[i]) {
      visit[i] = true;
      select.push(i);

      dfs(depth + 1);

      select.pop();
      visit[i] = false;
    }
  }
}

dfs(0);
console.log(result.join("\n"));
