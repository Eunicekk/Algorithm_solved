const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

let [n, m] = input[0].split(" ").map(Number);
let map = [];
let visit = Array.from({ length: n }, () => Array(n).fill(false));
let select = Array.from({ length: m }, () => Array(2).fill(0));
let min = Infinity;

for (let i = 1; i < n + 1; i++) {
  map.push(input[i].split(" ").map(Number));
}

const getDistance = (select) => {
  let distSum = 0;

  for (let r = 0; r < n; r++) {
    for (let c = 0; c < n; c++) {
      if (map[r][c] === 1) {
        let minDist = Infinity;

        for (let [sr, sc] of select) {
          let dist = Math.abs(r - sr) + Math.abs(c - sc);
          minDist = Math.min(minDist, dist);
        }

        distSum += minDist;
      }
    }
  }

  return distSum;
};

const dfs = (depth, start) => {
  if (depth === m) {
    min = Math.min(min, getDistance(select));
    return;
  }

  for (let index = start; index < n * n; index++) {
    let i = Math.floor(index / n);
    let j = index % n;

    if (map[i][j] === 2) {
      select[depth] = [i, j];
      dfs(depth + 1, index + 1);
    }
  }
};

dfs(0, 0);
console.log(min);
