const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let dr = [-1, 1, 0, 0];
let dc = [0, 0, -1, 1];

let [n, m] = input[0].split(" ").map(Number);
let map = Array.from({ length: n }, () => []);

for (let i = 1; i <= n; i++) {
  map[i - 1] = input[i].split(" ").map(Number);
}

let time = 0;

const bfs = () => {
  let visit = Array.from({ length: n }, () => Array(m).fill(false));
  let queue = [[0, 0]];
  let head = 0;
  visit[0][0] = true;

  while (head < queue.length) {
    let [r, c] = queue[head++];

    for (let d = 0; d < 4; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
        if (!visit[nr][nc] && map[nr][nc] === 0) {
          visit[nr][nc] = true;
          queue.push([nr, nc]);
        }
      }
    }
  }

  return visit;
};

while (true) {
  let visit = bfs();
  let melt = [];

  for (let r = 0; r < n; r++) {
    for (let c = 0; c < m; c++) {
      if (map[r][c] === 1) {
        let count = 0;

        for (let d = 0; d < 4; d++) {
          let nr = r + dr[d];
          let nc = c + dc[d];

          if (visit[nr][nc]) {
            count++;
          }
        }

        if (count >= 2) {
          melt.push([r, c]);
        }
      }
    }
  }

  if (melt.length === 0) {
    break;
  }

  for (let [r, c] of melt) {
    map[r][c] = 0;
  }

  time++;
}

console.log(time);
