const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, m] = input[0].split(" ").map(Number);
let graph = Array.from({ length: n + 1 }, () => Array(n + 1).fill(0));
let index = 1;

for (let i = 0; i < n - 1; i++) {
  let [from, to, dist] = input[index++].split(" ").map(Number);
  graph[from][to] = dist;
  graph[to][from] = dist;
}

const dfs = (from, to, visit) => {
  let stack = [[from, 0]];

  while (stack.length > 0) {
    const [node, dist] = stack.pop();

    if (node === to) {
      return dist;
    }

    if (!visit[node]) {
      visit[node] = true;

      for (let next = 1; next < graph.length; next++) {
        if (graph[node][next] !== 0 && !visit[next]) {
          stack.push([next, dist + graph[node][next]]);
        }
      }
    }
  }
};

for (let i = 0; i < m; i++) {
  let [from, to] = input[index++].split(" ").map(Number);
  let visit = Array(n + 1).fill(false);

  let result = dfs(from, to, visit);
  console.log(result);
}
