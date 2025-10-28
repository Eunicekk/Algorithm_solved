const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

let numbers = input.map(Number);

while (true) {
  for (let i = 0; i < 4; i++) {
    if (numbers[i] > numbers[i + 1]) {
      [numbers[i], numbers[i + 1]] = [numbers[i + 1], numbers[i]];
      console.log(numbers.join(" "));
    }

    if (numbers.join(" ") === "1 2 3 4 5") {
      return;
    }
  }
}
