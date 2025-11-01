const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

let n = Number(input[0]);
let map = [];

for (let i = 1; i < n + 1; i++) {
  map.push(input[i].split(" ").map(Number));
}

const bfs = (sr, sc, target, visit) => {
  let queue = [[sr, sc]];
  visit[sr][sc] = true;

  while (queue.length > 0) {
    let [r, c] = queue.shift();

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (
        nr >= 0 &&
        nc >= 0 &&
        nr < n &&
        nc < n &&
        !visit[nr][nc] &&
        map[nr][nc] > target
      ) {
        queue.push([nr, nc]);
        visit[nr][nc] = true;
      }
    }
  }
};

let max = 0;

for (let rain = 0; rain <= 100; rain++) {
  let visit = Array.from({ length: n }, () => Array(n).fill(false));
  let count = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (!visit[i][j] && map[i][j] > rain) {
        bfs(i, j, rain, visit);
        count++;
      }
    }
  }

  max = Math.max(max, count);
}

console.log(max);
