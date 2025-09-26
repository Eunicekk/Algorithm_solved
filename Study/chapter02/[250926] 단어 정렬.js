const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  if (a.length > b.length) {
    return 1;
  } else if (a.length < b.length) {
    return -1;
  } else {
    return a > b ? 1 : -1;
  }
};

const words = new Set(input.slice(1).sort(compare));

words.forEach((word) => {
  console.log(word);
});
