const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

let [n, k] = input[0].split(" ").map(Number);
let map = [];
let viruses = [];

for (let i = 1; i <= n; i++) {
  let row = input[i].split(" ").map(Number);
  map.push(row);

  for (let j = 0; j < n; j++) {
    if (row[j] !== 0) {
      viruses.push([row[j], 0, i - 1, j]);
    }
  }
}

let [s, x, y] = input[n + 1].split(" ").map(Number);

viruses.sort((a, b) => a[0] - b[0]);

let queue = [...viruses];

while (queue.length > 0) {
  let [virus, time, r, c] = queue.shift();

  if (time === s) {
    break;
  }

  for (let d = 0; d < 4; d++) {
    let nr = r + dr[d];
    let nc = c + dc[d];

    if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
      if (map[nr][nc] === 0) {
        map[nr][nc] = virus;
        queue.push([virus, time + 1, nr, nc]);
      }
    }
  }
}

console.log(map[x - 1][y - 1]);
