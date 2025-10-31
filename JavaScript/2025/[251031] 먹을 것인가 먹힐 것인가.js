const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);
let index = 1;

for (let t = 0; t < T; t++) {
  let count = 0;
  let [n, m] = input[index++].split(" ").map(Number);
  let n_array = input[index++]
    .split(" ")
    .map(Number)
    .sort((a, b) => b - a);
  let m_array = input[index++]
    .split(" ")
    .map(Number)
    .sort((a, b) => b - a);

  let n_left = 0;
  let m_left = 0;

  while (n_left < n && m_left < m) {
    if (n_array[n_left] > m_array[m_left]) {
      count += m - m_left;
      n_left++;
    } else {
      m_left++;
    }
  }

  console.log(count);
}
