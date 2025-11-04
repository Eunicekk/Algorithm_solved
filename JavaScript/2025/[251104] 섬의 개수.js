const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [-1, 1, 0, 0, -1, -1, 1, 1];
const dc = [0, 0, -1, 1, -1, 1, -1, 1];
let index = 0;

const bfs = (sr, sc, w, h, map, visit) => {
  let queue = [[sr, sc]];
  visit[sr][sc] = true;

  while (queue.length > 0) {
    let [r, c] = queue.shift();

    for (let d = 0; d < 8; d++) {
      let nr = r + dr[d];
      let nc = c + dc[d];

      if (
        nr >= 0 &&
        nc >= 0 &&
        nr < h &&
        nc < w &&
        !visit[nr][nc] &&
        map[nr][nc] === 1
      ) {
        queue.push([nr, nc]);
        visit[nr][nc] = true;
      }
    }
  }
};

while (true) {
  let [w, h] = input[index++].split(" ").map(Number);
  let map = [];
  let visit = Array.from({ length: h }, () => Array(w).fill(false));
  let count = 0;

  if (w === 0 && h === 0) {
    break;
  }

  for (let i = 0; i < h; i++) {
    map.push(input[index++].split(" ").map(Number));
  }

  for (let i = 0; i < h; i++) {
    for (let j = 0; j < w; j++) {
      if (!visit[i][j] && map[i][j] === 1) {
        count++;
        bfs(i, j, w, h, map, visit);
      }
    }
  }

  console.log(count);
}
