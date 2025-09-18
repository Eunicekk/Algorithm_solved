const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const A = Number(input[0].split(" ")[0]);
const B = Number(input[0].split(" ")[1]);
const C = Number(input[1]);

if (parseInt((B + C) / 60) > 0) {
  const add = parseInt((B + C) / 60);

  if (A + add >= 24) {
    console.log(A + add - 24, (B + C) % 60);
  } else {
    console.log(A + add, (B + C) % 60);
  }
} else {
  console.log(A, B + C);
}
