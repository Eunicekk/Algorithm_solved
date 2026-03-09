-- 동물의 이름은 몇 개인지 조회
-- 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 고려
SELECT COUNT(DISTINCT NAME) AS count
FROM ANIMAL_INS;
