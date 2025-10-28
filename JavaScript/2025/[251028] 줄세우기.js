const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);

for (let t = 1; t < T + 1; t++) {
  let problem = Number(input[t].split(" ")[0]);
  let students = input[t].split(" ").map(Number).slice(1);
  let result = 0;

  for (let i = 0; i < students.length - 1; i++) {
    for (let j = 0; j < students.length - i - 1; j++) {
      if (students[j] > students[j + 1]) {
        [students[j], students[j + 1]] = [students[j + 1], students[j]];
        result++;
      }
    }
  }

  console.log(problem, result);
}
