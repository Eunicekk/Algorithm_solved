const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);
let index = 1;

for (let t = 0; t < T; t++) {
  let [v, e] = input[index++].split(" ").map(Number);
  let graph = Array.from({ length: v + 1 }, () => []);
  let color = Array(v + 1).fill(0);

  for (let i = 0; i < e; i++) {
    let [a, b] = input[index++].split(" ").map(Number);
    graph[a].push(b);
    graph[b].push(a);
  }

  let isBipartite = true;

  const bfs = (start) => {
    let queue = [start];
    color[start] = 1;

    while (queue.length && isBipartite) {
      const current = queue.shift();

      for (let next of graph[current]) {
        if (color[next] === 0) {
          color[next] = -color[current];
          queue.push(next);
        } else if (color[next] === color[current]) {
          isBipartite = false;
          return;
        }
      }
    }
  };

  for (let i = 1; i <= v; i++) {
    if (color[i] === 0) {
      bfs(i);
    }
  }

  console.log(isBipartite ? "YES" : "NO");
}
