const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let friends = Array.from({ length: n }, () => Array(n).fill(Infinity));

for (let i = 0; i < n; i++) {
  let line = input[i + 1].split("");

  for (let j = 0; j < n; j++) {
    if (i === j) {
      friends[i][j] = 0;
    } else if (line[j] === "Y") {
      friends[i][j] = 1;
    }
  }
}

for (let k = 0; k < n; k++) {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (friends[i][j] > friends[i][k] + friends[k][j]) {
        friends[i][j] = friends[i][k] + friends[k][j];
      }
    }
  }
}

let result = 0;

for (let i = 0; i < n; i++) {
  let count = 0;

  for (let j = 0; j < n; j++) {
    if (i !== j && friends[i][j] <= 2) {
      count++;
    }

    result = Math.max(result, count);
  }
}

console.log(result);
