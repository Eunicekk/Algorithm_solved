const fs = require("fs");
const input = fs.readFileSync("input.txt").toString().trim().split("\n");

let [n, m, k, x] = input[0].split(" ").map(Number);
let graph = Array.from({ length: n + 1 }, () => []);

for (let i = 1; i <= m; i++) {
  let [a, b] = input[i].split(" ").map(Number);
  graph[a].push(b);
}

let dist = Array(n + 1).fill(-1);
let queue = [x];
dist[x] = 0;

while (queue.length > 0) {
  let current = queue.shift();

  for (let next of graph[current]) {
    if (dist[next] === -1) {
      dist[next] = dist[current] + 1;
      queue.push(next);
    }
  }
}

let result = [];
for (let i = 1; i <= n; i++) {
  if (dist[i] === k) {
    result.push(i);
  }
}

if (result.length === 0) {
  console.log(-1);
} else {
  console.log(result.join("\n"));
}
