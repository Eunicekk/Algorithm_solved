const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, m] = input[0].split(" ").map(Number);
let graph = Array.from({ length: n + 1 }, () => []);
let visit = Array(n).fill(false);
let count = 0;

for (let i = 1; i < m + 1; i++) {
  let [a, b] = input[i].split(" ").map(Number);
  graph[a].push(b);
  graph[b].push(a);
}

const dfs = (start) => {
  visit[start] = true;

  for (let value of graph[start]) {
    if (!visit[value]) {
      visit[value] = true;
      dfs(value);
    }
  }
};

for (let i = 1; i < n + 1; i++) {
  if (!visit[i]) {
    dfs(i);
    count++;
  }
}

console.log(count);
