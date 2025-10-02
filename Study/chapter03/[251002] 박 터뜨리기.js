const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const n = Number(input[0]);
const k = Number(input[1]);

let rule = (k * (k + 1)) / 2;

if (n < rule) {
  console.log(-1);
} else {
  let array = Array.from({ length: k }, (_, i) => i + 1);
  let diff = n - rule;

  let index = k - 1;

  while (diff > 0) {
    array[index]++;
    diff--;
    index--;

    if (index < 0) {
      index = k - 1;
    }
  }

  console.log(array[k - 1] - array[0]);
}
