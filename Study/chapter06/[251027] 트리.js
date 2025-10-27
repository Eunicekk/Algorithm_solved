const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let caseNum = 1;
let index = 0;

const dfs = (node, parent, graph, visit) => {
  visit[node] = true;

  for (let next of graph[node]) {
    if (!visit[next]) {
      if (dfs(next, node, graph, visit)) {
        return true;
      }
    } else if (next !== parent) {
      return true;
    }
  }

  return false;
};

while (true) {
  let [n, m] = input[index++].split(" ").map(Number);
  if (n === 0 && m === 0) {
    break;
  }

  let graph = Array.from({ length: n + 1 }, () => []);
  let visit = Array(n + 1).fill(false);
  let count = 0;

  for (let i = 0; i < m; i++) {
    let [from, to] = input[index++].split(" ").map(Number);
    graph[from].push(to);
    graph[to].push(from);
  }

  for (let i = 1; i <= n; i++) {
    if (!visit[i]) {
      let hasCycle = dfs(i, 0, graph, visit);
      if (!hasCycle) {
        count++;
      }
    }
  }

  if (count === 0) {
    console.log(`Case ${caseNum}: No trees.`);
  } else if (count === 1) {
    console.log(`Case ${caseNum}: There is one tree.`);
  } else {
    console.log(`Case ${caseNum}: A forest of ${count} trees.`);
  }

  caseNum++;
}
