const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split(" ");

const a = Number(input[0]);
const b = Number(input[1]);
const c = Number(input[2]);

if (a === b && b === c) {
  console.log(10000 + 1000 + a);
} else if (a === b) {
  console.log(1000 + 100 * a);
} else if (b === c) {
  console.log(1000 + 100 * b);
} else if (c === a) {
  console.log(1000 + 100 * c);
} else {
  const max = [a, b, c].reduce((n1, n2) => Math.max(n1, n2));
  console.log(100 * max);
}
