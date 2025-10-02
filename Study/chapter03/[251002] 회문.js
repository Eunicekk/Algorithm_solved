const fs = require("fs");
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const palindrome = (word) => {
  let left = 0;
  let right = word.length - 1;

  while (left < right) {
    if (word[left] === word[right]) {
      left++;
      right--;
    } else {
      if (isValid(word, left + 1, right) || isValid(word, left, right - 1)) {
        return 1;
      } else {
        return 2;
      }
    }
  }

  return 0;
};

const isValid = (word, left, right) => {
  while (left < right) {
    if (word[left] !== word[right]) {
      return false;
    }

    left++;
    right--;
  }

  return true;
};

for (let word of input) {
  console.log(palindrome(word));
}
