const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const m = Number(input[1]);

const graph = Array.from({ length: n + 1 }, () => []);
const visit = new Array(n).fill(false);
let result = 0;

for (let i = 2; i < 2 + m; i++) {
  let [a, b] = input[i].split(" ").map(Number);
  graph[a].push(b);
  graph[b].push(a);
}

function dfs(start) {
  let stack = [start];

  while (stack.length > 0) {
    let v = stack.pop();

    if (!visit[v]) {
      visit[v] = true;

      if (v !== 1) {
        result++;
      }

      for (let i = graph[v].length - 1; i >= 0; i--) {
        const next = graph[v][i];

        if (!visit[next]) {
          stack.push(next);
        }
      }
    }
  }
}

dfs(1);

console.log(result);
