const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);
let index = 1;

let dr = [2, 2, -2, -2, 1, 1, -1, -1];
let dc = [1, -1, 1, -1, 2, -2, 2, -2];

const bfs = (startR, startC, l, graph, visit) => {
  let queue = [[startR, startC, 0]];
  visit[startR][startC] = true;

  while (queue.length > 0) {
    let [r, c, dist] = queue.shift();

    if (graph[r][c] === 1) {
      return dist;
    }

    for (let d = 0; d < 8; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (nr >= 0 && nc >= 0 && nr < l && nc < l && !visit[nr][nc]) {
        queue.push([nr, nc, dist + 1]);
        visit[nr][nc] = true;
      }
    }
  }
};

for (let t = 0; t < T; t++) {
  let l = Number(input[index++]);
  let [startR, startC] = input[index++].split(" ").map(Number);
  let [endR, endC] = input[index++].split(" ").map(Number);

  let graph = Array.from({ length: l }, () => new Array(l).fill(0));
  let visit = Array.from({ length: l }, () => new Array(l).fill(false));

  graph[endR][endC] = 1;

  let result = bfs(startR, startC, l, graph, visit);
  console.log(result);
}
