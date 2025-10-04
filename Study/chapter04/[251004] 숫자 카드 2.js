const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const cards = input[1].split(" ").map(Number);
const m = Number(input[2]);
const rules = input[3].split(" ").map(Number);

cards.sort((a, b) => a - b);

const lowerBound = (array, target) => {
  let left = 0;
  let right = array.length;

  while (left < right) {
    let mid = parseInt((left + right) / 2);

    if (array[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
};

const upperBound = (array, target) => {
  let left = 0;
  let right = array.length;

  while (left < right) {
    let mid = parseInt((left + right) / 2);

    if (array[mid] > target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
};

let result = rules.map(
  (rule) => upperBound(cards, rule) - lowerBound(cards, rule),
);

console.log(result.join(" "));
