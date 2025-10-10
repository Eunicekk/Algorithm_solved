const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const T = Number(input[0]);
let index = 0;

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

function dfs(r, c, graph, n, m) {
  let stack = [[r, c]];

  while (stack.length > 0) {
    let [x, y] = stack.pop();

    for (let d = 0; d < 4; d++) {
      const nr = x + dr[d];
      const nc = y + dc[d];

      if (nr >= 0 && nc >= 0 && nr < n && nc < m && graph[nr][nc] === 1) {
        graph[nr][nc] = 0;
        stack.push([nr, nc]);
      }
    }
  }
}

for (let t = 0; t < T; t++) {
  const [m, n, k] = input[++index].split(" ").map(Number);
  const graph = Array.from({ length: n }, () => new Array(m).fill(0));
  let result = 0;

  for (let i = 0; i < k; i++) {
    let [a, b] = input[++index].split(" ").map(Number);
    graph[b][a] = 1;
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (graph[i][j] === 1) {
        dfs(i, j, graph, n, m);
        result++;
      }
    }
  }

  console.log(result);
}
