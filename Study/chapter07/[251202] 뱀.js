const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let dr = [0, 1, 0, -1];
let dc = [1, 0, -1, 0];

let N = Number(input[0]);
let K = Number(input[1]);
let L = Number(input[K + 2]);

let map = Array.from({ length: N }, () => Array(N).fill(0));

for (let i = 1; i <= K; i++) {
  let [r, c] = input[i + 1].split(" ").map(Number);
  map[r - 1][c - 1] = 1;
}

let turns = {};

for (let i = 1; i <= L; i++) {
  let [t, d] = input[K + 2 + i].split(" ");
  turns[Number(t)] = d;
}

let dir = 0;
let time = 0;
let snake = [[0, 0]];
let set = new Set();
set.add("0,0");

while (true) {
  time++;

  let [hr, hc] = snake[snake.length - 1];
  let nr = hr + dr[dir];
  let nc = hc + dc[dir];

  if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
    break;
  }

  if (set.has(`${nr},${nc}`)) {
    break;
  }

  snake.push([nr, nc]);
  set.add(`${nr},${nc}`);

  if (map[nr][nc] === 1) {
    map[nr][nc] = 0;
  } else {
    let [tr, tc] = snake.shift();
    set.delete(`${tr},${tc}`);
  }

  if (turns[time]) {
    if (turns[time] === "D") {
      dir = (dir + 1) % 4;
    } else {
      dir = (dir + 3) % 4;
    }
  }
}

console.log(time);
