const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const meetings = input.slice(1).map((meet) => meet.split(" ").map(Number));

meetings.sort((a, b) => {
  if (a[1] !== b[1]) {
    return a[1] - b[1];
  } else {
    return a[0] - b[0];
  }
});

let result = 1;
let current = 0;

for (let i = 1; i < n; i++) {
  if (meetings[current][1] <= meetings[i][0]) {
    current = i;
    result++;
  }
}

console.log(result);
