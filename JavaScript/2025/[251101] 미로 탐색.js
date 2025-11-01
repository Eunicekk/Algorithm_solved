const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

let [n, m] = input[0].split(" ").map(Number);
let maze = [];
let visit = Array.from({ length: n }, () => Array(m).fill(false));

for (let i = 1; i < n + 1; i++) {
  maze.push(input[i].split("").map(Number));
}

const bfs = (sr, sc) => {
  let queue = [[sr, sc, 1]];
  visit[sr][sc] = true;

  while (queue.length > 0) {
    let [r, c, p] = queue.shift();

    if (r === n - 1 && c === m - 1) {
      return p;
    }

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (
        nr >= 0 &&
        nc >= 0 &&
        nr < n &&
        nc < m &&
        !visit[nr][nc] &&
        maze[nr][nc] === 1
      ) {
        count = p + 1;
        queue.push([nr, nc, p + 1]);
        visit[nr][nc] = true;
      }
    }
  }
};

let result = bfs(0, 0);
console.log(result);
