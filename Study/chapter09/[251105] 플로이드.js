const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let m = Number(input[1]);

let dist = Array.from({ length: n + 1 }, () => Array(n + 1).fill(Infinity));

for (let i = 1; i <= n; i++) {
  dist[i][i] = 0;
}

for (let i = 2; i < m + 2; i++) {
  let [a, b, c] = input[i].split(" ").map(Number);
  dist[a][b] = Math.min(dist[a][b], c);
}

for (let k = 1; k <= n; k++) {
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
      if (dist[i][j] > dist[i][k] + dist[k][j]) {
        dist[i][j] = dist[i][k] + dist[k][j];
      }
    }
  }
}

let result = "";

for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) {
    result += (dist[i][j] === Infinity ? 0 : dist[i][j]) + " ";
  }
  result += "\n";
}

console.log(result.trim());
